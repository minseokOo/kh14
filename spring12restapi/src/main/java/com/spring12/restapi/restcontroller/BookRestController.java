package com.spring12.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.dao.BookDao;
import com.spring12.restapi.dto.BookDto;
import com.spring12.restapi.error.TargetNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//문서에 표시될 정보를 설정
@Tag(name = "도서 관리 정보처리 도구")

@CrossOrigin(origins= {"http://localhost:3000"})
@RestController
@RequestMapping("/book")
public class BookRestController {
	
	@Autowired
	private BookDao bookDao;
	
	//조회 매핑에 대한 API 문서 설명 추가
	@Operation(
			deprecated = false, //비추천 여부(사용 중지 예정인 경우 true로 설정)
			description = "도서 정보에 대한 조회를 처리해주는 Rest API 입니다.", //설명
			responses = { //예상 가능한  응답코드에 대한 안내
					@ApiResponse(//정상
						responseCode = "200", //상태 코드
						description = "조회 완료",  //설명
						content = @Content( //결과 메세지의 형태와 샘플
							mediaType = "application/json", //결과 메세지의 MIME 타입
							array = @ArraySchema(//결과가 배열일 경우에 대한 안내
								schema = @Schema(implementation = BookDto.class))
							//List<BookDto> == List(@ArraySchema)<BookDto(@Schema)>
						)
					), 
					@ApiResponse(//서버 오류
						responseCode = "500", //상태 코드 
						description = "서버 오류", // 설명
						content = @Content(//결과 메세지의 형태와 샘플
							mediaType = "text/plain", //결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class)//자바의 자료형
							,examples = @ExampleObject("server error")
						)
					)
			}
	)
	
	@GetMapping("/")
	public List<BookDto> list(){
		return bookDao.selectList();
	
	}

	@Operation(
		description = "도서 정보 상세 조회",
		responses = {
				@ApiResponse(//정상
						responseCode = "200", //상태 코드
						description = "조회 완료",  //설명
						content = @Content( //결과 메세지의 형태와 샘플
							mediaType = "application/json", //결과 메세지의 MIME 타입
							array = @ArraySchema(//결과가 배열일 경우에 대한 안내
								schema = @Schema(implementation = BookDto.class))
							//List<BookDto> == List(@ArraySchema)<BookDto(@Schema)>
						)
					), 
				@ApiResponse(responseCode = "404", //상태 코드 
				description = "대상을 찾을 수 없음", // 설명
				content = @Content(//결과 메세지의 형태와 샘플
					mediaType = "text/plain", //결과 메세지의 MIME 타입
					schema = @Schema(implementation = String.class)//자바의 자료형
					,examples = @ExampleObject("target not found")//예시 데이터
				)
		),
				@ApiResponse(//서버 오류
						responseCode = "500", //상태 코드 
						description = "서버 오류", // 설명
						content = @Content(//결과 메세지의 형태와 샘플
							mediaType = "text/plain", //결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class)//자바의 자료형
							,examples = @ExampleObject("server error") //예시 데이터
						)
				)
		}
	)
	@GetMapping("/{bookId}")
	public BookDto detail(
			@Parameter(required = true, description = "도서 번호") 
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null)
			throw new TargetNotFoundException();
		return bookDto;
	}
	
	@Operation(
		description = "도서 등록",
		responses = {
				@ApiResponse(
					responseCode = "200",//상태 코드
					description = "등록 완료",
					content = @Content( //결과 메세지의 형태와 샘플
						schema = @Schema(implementation = Void.class)//없는 경우(void)
					)
				),
				@ApiResponse(
						responseCode = "500", //상태 코드 
						description = "서버 오류", // 설명
						content = @Content(//결과 메세지의 형태와 샘플
							mediaType = "text/plain", //결과 메세지의 MIME 타입
							schema = @Schema(implementation = String.class),//자바의 자료형
							examples = @ExampleObject("server error") //예시 데이터
						)
				)
		}
	)
	@PostMapping("/")//등록
	public void insert(@RequestBody BookDto bookDto) {
		bookDao.insert(bookDto);
		
	}
	
	@Operation(
			description = "도서 수정",
			responses = {
					@ApiResponse(
						responseCode = "200",//상태 코드
						description = "수정 완료",
						content = @Content( //결과 메세지의 형태와 샘플
							schema = @Schema(implementation = Void.class)//없는 경우(void)
						)
					),
					@ApiResponse(responseCode = "404", //상태 코드 
					description = "대상을 찾을 수 없음", // 설명
					content = @Content(//결과 메세지의 형태와 샘플
						mediaType = "text/plain", //결과 메세지의 MIME 타입
						schema = @Schema(implementation = String.class),//자바의 자료형
						examples = @ExampleObject("target not found")//예시 데이터
					)
			),
					@ApiResponse(
							responseCode = "500", //상태 코드 
							description = "서버 오류", // 설명
							content = @Content(//결과 메세지의 형태와 샘플
								mediaType = "text/plain", //결과 메세지의 MIME 타입
								schema = @Schema(implementation = String.class),//자바의 자료형
								examples = @ExampleObject("server error") //예시 데이터
							)
					)
			}
		)
	@PutMapping("/")//수정
	public void edit(@RequestBody BookDto bookDto) {
		//[1] 수정 후 적용여부를 이용하여 404 처리 (DB를 한번만 조회)
		boolean result = bookDao.update(bookDto);
		if(result == false) throw new TargetNotFoundException();
		
		//[2] 선 조회 후 수정하는 방법 (DB를 두번 조회)
//		BookDto findDto = bookDao.selectOne(bookDto.getBookId());
//		if(findDto == null) throw new TargetNotFoundException();
//		bookDao.update(bookDto);
	}
	
	@Operation(
			description = "도서 삭제",
			responses = {
					@ApiResponse(
						responseCode = "200",//상태 코드
						description = "삭제 완료",
						content = @Content( //결과 메세지의 형태와 샘플
							schema = @Schema(implementation = Void.class)//없는 경우(void)
						)
					),
					@ApiResponse(responseCode = "404", //상태 코드 
					description = "대상을 찾을 수 없음", // 설명
					content = @Content(//결과 메세지의 형태와 샘플
						mediaType = "text/plain", //결과 메세지의 MIME 타입
						schema = @Schema(implementation = String.class),//자바의 자료형
						examples = @ExampleObject("target not found")//예시 데이터
					)
			),
					@ApiResponse(
							responseCode = "500", //상태 코드 
							description = "서버 오류", // 설명
							content = @Content(//결과 메세지의 형태와 샘플
								mediaType = "text/plain", //결과 메세지의 MIME 타입
								schema = @Schema(implementation = String.class),//자바의 자료형
								examples = @ExampleObject("server error") //예시 데이터
							)
					)
			}
		)
	@DeleteMapping("/{bookId}")//삭제
	public void delete(
		@Parameter(example = "1", description = "도서 번호")
		@PathVariable int bookId) {
		//[1] 삭제 후 결과를 이용하여 404 처리
		boolean result = bookDao.delete(bookId);
		if(result == false) throw new TargetNotFoundException();
		
		//[2] 선 조회 후 삭제 처리
//		BookDto bookDto = bookDao.selectOne(bookId);
//		if(bookDto == null) throw new TargetNotFoundException();
//		bookDao.delete(bookId);
	}
		
	
	
}
