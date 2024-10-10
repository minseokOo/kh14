package com.spring12.restapi.restcontroller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.dao.BookDao;
import com.spring12.restapi.dao.PaymentDao;
import com.spring12.restapi.dto.BookDto;
import com.spring12.restapi.dto.PaymentDetailDto;
import com.spring12.restapi.dto.PaymentDto;
import com.spring12.restapi.error.TargetNotFoundException;
import com.spring12.restapi.service.KakaoPayService;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.BookApproveRequestVO;
import com.spring12.restapi.vo.BookPurchaseRequestVO;
import com.spring12.restapi.vo.BookQtyVO;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.PaymentTotalVO;
import com.spring12.restapi.vo.pay.KakaoPayApproveRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayApproveResponseVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

//문서에 표시될 정보를 설정
@Tag(name = "도서 관리 정보처리 도구")

@Slf4j

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private PaymentDao paymentDao;

	// 조회 매핑에 대한 API 문서 설명 추가
	@Operation(deprecated = false, // 비추천 여부(사용 중지 예정인 경우 true로 설정)
			description = "도서 정보에 대한 조회를 처리해주는 Rest API 입니다.", // 설명
			responses = { // 예상 가능한 응답코드에 대한 안내
					@ApiResponse(// 정상
							responseCode = "200", // 상태 코드
							description = "조회 완료", // 설명
							content = @Content( // 결과 메세지의 형태와 샘플
									mediaType = "application/json", // 결과 메세지의 MIME 타입
									array = @ArraySchema(// 결과가 배열일 경우에 대한 안내
											schema = @Schema(implementation = BookDto.class))
							// List<BookDto> == List(@ArraySchema)<BookDto(@Schema)>
							)), @ApiResponse(// 서버 오류
									responseCode = "500", // 상태 코드
									description = "서버 오류", // 설명
									content = @Content(// 결과 메세지의 형태와 샘플
											mediaType = "text/plain", // 결과 메세지의 MIME 타입
											schema = @Schema(implementation = String.class)// 자바의 자료형
											, examples = @ExampleObject("server error"))) })

	@GetMapping("/")
	public List<BookDto> list() {
		return bookDao.selectList();

	}

	@GetMapping("/column/{column}/keyword/{keyword}")
	public List<BookDto> search(@PathVariable String column, @PathVariable String keyword) {
		List<BookDto> list = bookDao.selectList(column, keyword);
		return list;
	}

	@Operation(description = "도서 정보 상세 조회", responses = { @ApiResponse(// 정상
			responseCode = "200", // 상태 코드
			description = "조회 완료", // 설명
			content = @Content( // 결과 메세지의 형태와 샘플
					mediaType = "application/json", // 결과 메세지의 MIME 타입
					array = @ArraySchema(// 결과가 배열일 경우에 대한 안내
							schema = @Schema(implementation = BookDto.class))
			// List<BookDto> == List(@ArraySchema)<BookDto(@Schema)>
			)), @ApiResponse(responseCode = "404", // 상태 코드
					description = "대상을 찾을 수 없음", // 설명
					content = @Content(// 결과 메세지의 형태와 샘플
							mediaType = "text/plain", // 결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class)// 자바의 자료형
							, examples = @ExampleObject("target not found")// 예시 데이터
					)), @ApiResponse(// 서버 오류
							responseCode = "500", // 상태 코드
							description = "서버 오류", // 설명
							content = @Content(// 결과 메세지의 형태와 샘플
									mediaType = "text/plain", // 결과 메세지의 MIME 타입
									schema = @Schema(implementation = String.class)// 자바의 자료형
									, examples = @ExampleObject("server error") // 예시 데이터
							)) })
	@GetMapping("/{bookId}")
	public BookDto detail(@Parameter(required = true, description = "도서 번호") @PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if (bookDto == null)
			throw new TargetNotFoundException();
		return bookDto;
	}

	@Operation(description = "도서 등록", responses = { @ApiResponse(responseCode = "200", // 상태 코드
			description = "등록 완료", content = @Content( // 결과 메세지의 형태와 샘플
					schema = @Schema(implementation = Void.class)// 없는 경우(void)
			)), @ApiResponse(responseCode = "500", // 상태 코드
					description = "서버 오류", // 설명
					content = @Content(// 결과 메세지의 형태와 샘플
							mediaType = "text/plain", // 결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class), // 자바의 자료형
							examples = @ExampleObject("server error") // 예시 데이터
					)) })
	@PostMapping("/") // 등록
	public void insert(@RequestBody BookDto bookDto) {
		bookDao.insert(bookDto);

	}

	@Operation(description = "도서 수정", responses = { @ApiResponse(responseCode = "200", // 상태 코드
			description = "수정 완료", content = @Content( // 결과 메세지의 형태와 샘플
					schema = @Schema(implementation = Void.class)// 없는 경우(void)
			)), @ApiResponse(responseCode = "404", // 상태 코드
					description = "대상을 찾을 수 없음", // 설명
					content = @Content(// 결과 메세지의 형태와 샘플
							mediaType = "text/plain", // 결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class), // 자바의 자료형
							examples = @ExampleObject("target not found")// 예시 데이터
					)), @ApiResponse(responseCode = "500", // 상태 코드
							description = "서버 오류", // 설명
							content = @Content(// 결과 메세지의 형태와 샘플
									mediaType = "text/plain", // 결과 메세지의 MIME 타입
									schema = @Schema(implementation = String.class), // 자바의 자료형
									examples = @ExampleObject("server error") // 예시 데이터
							)) })
	@PutMapping("/") // 수정
	public void edit(@RequestBody BookDto bookDto) {
		// [1] 수정 후 적용여부를 이용하여 404 처리 (DB를 한번만 조회)
		boolean result = bookDao.update(bookDto);
		if (result == false)
			throw new TargetNotFoundException();

		// [2] 선 조회 후 수정하는 방법 (DB를 두번 조회)
//		BookDto findDto = bookDao.selectOne(bookDto.getBookId());
//		if(findDto == null) throw new TargetNotFoundException();
//		bookDao.update(bookDto);
	}

	@Operation(description = "도서 삭제", responses = { @ApiResponse(responseCode = "200", // 상태 코드
			description = "삭제 완료", content = @Content( // 결과 메세지의 형태와 샘플
					schema = @Schema(implementation = Void.class)// 없는 경우(void)
			)), @ApiResponse(responseCode = "404", // 상태 코드
					description = "대상을 찾을 수 없음", // 설명
					content = @Content(// 결과 메세지의 형태와 샘플
							mediaType = "text/plain", // 결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class), // 자바의 자료형
							examples = @ExampleObject("target not found")// 예시 데이터
					)), @ApiResponse(responseCode = "500", // 상태 코드
							description = "서버 오류", // 설명
							content = @Content(// 결과 메세지의 형태와 샘플
									mediaType = "text/plain", // 결과 메세지의 MIME 타입
									schema = @Schema(implementation = String.class), // 자바의 자료형
									examples = @ExampleObject("server error") // 예시 데이터
							)) })
	@DeleteMapping("/{bookId}") // 삭제
	public void delete(@Parameter(example = "1", description = "도서 번호") @PathVariable int bookId) {
		// [1] 삭제 후 결과를 이용하여 404 처리
		boolean result = bookDao.delete(bookId);
		if (result == false)
			throw new TargetNotFoundException();

		// [2] 선 조회 후 삭제 처리
//		BookDto bookDto = bookDao.selectOne(bookId);
//		if(bookDto == null) throw new TargetNotFoundException();
//		bookDao.delete(bookId);
	}

	// 구매
	@Autowired
	private TokenService tokenService;
	@Autowired
	private KakaoPayService kakaoPayService;

	@PostMapping("/purchase")
	public KakaoPayReadyResponseVO purchase(@RequestBody BookPurchaseRequestVO request,
			@RequestHeader("Authorization") String token) throws URISyntaxException {
		// 카카오 페이에 보낼 최종 결제 정보를 생성
		// 결제 준비요청을 하고
		// 사용자에게 필요한 정보를 전달
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));

		// 상품명, 금액을 계산
		StringBuffer buffer = new StringBuffer();
		int total = 0;
		for (BookQtyVO vo : request.getBookList()) {
			BookDto bookDto = bookDao.selectOne(vo.getBookId());// 도서 정보 조회
			if (bookDto == null)
				throw new TargetNotFoundException("결제 대상 없음");
			total += bookDto.getBookPrice() * vo.getQty();// 도서가격 * 구매수량

			if (buffer.isEmpty()) {// 버퍼가 비어 있을경우
				buffer.append(bookDto.getBookTitle());// 제목 추가
			}
		}
		if (request.getBookList().size() > 2) {// 구매가 2건 이상이라면
			buffer.append("외 " + (request.getBookList().size() - 1) + "건");
		}

		KakaoPayReadyRequestVO requestVO = new KakaoPayReadyRequestVO();
		requestVO.setPartnerOrderId(UUID.randomUUID().toString());
		requestVO.setPartnerUserId(claimVO.getMemberId());
		requestVO.setItemName(buffer.toString());
		requestVO.setTotalAmount(total);
		requestVO.setApprovalUrl(request.getApprovalUrl());
		requestVO.setCancelUrl(request.getCancelUrl());
		requestVO.setFailUrl(request.getFailUrl());

		log.info("request = {}", request);
		KakaoPayReadyResponseVO response = kakaoPayService.ready(requestVO);

		return response;
	}

	@PostMapping("/approve")
	public KakaoPayApproveResponseVO approve(@RequestHeader("Authorization") String token,
			@RequestBody BookApproveRequestVO request) throws URISyntaxException {

		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));

		KakaoPayApproveRequestVO requestVO = new KakaoPayApproveRequestVO();
		requestVO.setPartnerOrderId(request.getPartnerOrderId());
		requestVO.setPartnerUserId(claimVO.getMemberId());
		requestVO.setTid(request.getTid());
		requestVO.setPgToken(request.getPgToken());

		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);

		int paymentSeq = paymentDao.paymentSequence();
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setPaymentNo(paymentSeq);// 결제번호
		paymentDto.setPaymentTid(responseVO.getTid());// 거래번호
		paymentDto.setPaymentName(responseVO.getItemName());
		paymentDto.setPaymentTotal(responseVO.getAmount().getTotal());
		paymentDto.setPaymentRemain(paymentDto.getPaymentTotal());
		paymentDto.setMemberId(claimVO.getMemberId());
		paymentDao.paymentInsert(paymentDto);//대표정보 등록
		
		//[2] 상세 정보 등록
		for(BookQtyVO qtyVO : request.getBookList()) {
			BookDto bookDto = bookDao.selectOne(qtyVO.getBookId());//도서조회
			if(bookDto == null) throw new TargetNotFoundException("존재하지 않는 도서번호");
			
			int paymentDetailSeq = paymentDao.paymentDetailSequence();//번호추출
			PaymentDetailDto paymentDetailDto = new PaymentDetailDto();
			paymentDetailDto.setPaymentDetailNo(paymentDetailSeq);
			paymentDetailDto.setPaymentDetailName(bookDto.getBookTitle());
			paymentDetailDto.setPaymentDetailPrice(bookDto.getBookPrice());
			paymentDetailDto.setPaymentDetailItem(bookDto.getBookId());
			paymentDetailDto.setPaymentDetailQty(qtyVO.getQty());
			paymentDetailDto.setPaymentDetailOrigin(paymentSeq);
			paymentDao.paymentDetailInsert(paymentDetailDto);
				
			
		}
		return responseVO;
	}
	
	
	//구매 내역 조회
	@GetMapping("/paymentlist")
	public List<PaymentDto> paymentList(@RequestHeader("Authorization") String token) {
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
		List<PaymentDto> list = paymentDao.selectList(claimVO.getMemberId());
		return list;
	}
	
	//구매 내역 상세 조회
	
	@GetMapping("/paymentlist/{paymentNo}")
	public List<PaymentDetailDto> paymentDetailList(
			@RequestHeader("Authorization") String token,
			@PathVariable int paymentNo) {
		//사용자 정보 추출
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
		
		PaymentDto paymentDto = paymentDao.selectOne(paymentNo);
		if(paymentDto == null)
			throw new TargetNotFoundException("존재하지 않는 결제번호");
		if(!paymentDto.getMemberId().equals(claimVO.getMemberId()))//내 결제정보가 아니라면
			throw new TargetNotFoundException("잘못된 대상의 결제번호");
		
		List<PaymentDetailDto> list = paymentDao.selectDetailList(paymentNo);
		return list;
	}
	
	@GetMapping("/paymentTotalList")
	public List<PaymentTotalVO> paymentTotalList(@RequestHeader("Authorization") String token){
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
		return paymentDao.selectTotalList(claimVO.getMemberId());
	}

}
