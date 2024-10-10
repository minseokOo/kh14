package com.spring12.restapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.dao.MemberDao;
import com.spring12.restapi.dao.MemberTokenDao;
import com.spring12.restapi.dto.MemberDto;
import com.spring12.restapi.dto.MemberTokenDto;
import com.spring12.restapi.error.TargetNotFoundException;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.MemberComplexRequestVO;
import com.spring12.restapi.vo.MemberComplexResponseVO;
import com.spring12.restapi.vo.MemberLoginRequestVO;
import com.spring12.restapi.vo.MemberLoginResponseVO;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private MemberTokenDao memberTokenDao;

	// 여태까지 배운대로라면 복합검색도 GET으로 구현해야 한다
	// 하지만 보내에 하는 데이터가 너무 많아서 GET으로 구현하는 것은 어려움이 있다
	// 해결을 위해 HTTP BODY를 가지는 방식 중 POST를 사용한다
	@PostMapping("/search") // 회원가입과 구분하기 위해 눈물을 머금고 주소 규칙을 깬다
	public MemberComplexResponseVO search(@RequestBody MemberComplexRequestVO vo) {

		int count = memberDao.complexSearchCount(vo);
		// 마지막 = 페이징을 안쓰는 경우 or 검색개수가 종료번호보다 작거나 같은 경우
		boolean last = vo.getEndRow() == null || count <= vo.getEndRow();

		MemberComplexResponseVO response = new MemberComplexResponseVO();
		response.setMemberList(memberDao.complexSearch(vo));
		response.setCount(count);
		response.setLast(last);
		return response;
	}

	// 로그인 관련 처리 기능
	// - 로그인은 등록/목록(검색)/상세/수정/삭제 중에 해당되는게 없다
	// - 기본적인 기능이 아닌 특수한 목적을 가진 변형된 기능
	// - 표준 규칙을 따르기가 어렵다
	@PostMapping("/login")
	public MemberLoginResponseVO login(@RequestBody MemberLoginRequestVO vo) {

		// 회원 조회
		MemberDto memberDto = memberDao.selectOne(vo.getMemberId());
		if (memberDto == null) {// 아이디 없음
			throw new TargetNotFoundException("아이디 없음");
		}

		// 비밀번호 비교(암호화 여부에 따라 코드가 달라질 수 있음에 주의)
		boolean isValid = vo.getMemberPw().equals(memberDto.getMemberPw());// 암호화X
//		boolean isValid = encoder.matches(vo.getMemberPw(), memberDto.memberPw());//암호화O

		if (isValid) {// 로그인 성공
			MemberLoginResponseVO response = new MemberLoginResponseVO();
			// 아이디, 등급, 액세스토큰
			response.setMemberId(memberDto.getMemberId());// 아이디
			response.setMemberLevel(memberDto.getMemberLevel());// 등급
			MemberClaimVO claimVO = new MemberClaimVO();
			claimVO.setMemberId(memberDto.getMemberId());
			claimVO.setMemberLevel(memberDto.getMemberLevel());
			response.setAccessToken(tokenService.createAccessToken(claimVO));// 액세스토큰
			response.setRefreshToken(tokenService.createRefreshToken(claimVO));// 리프레시토큰
			return response;
		} else {// 로그인 실패
			throw new TargetNotFoundException("비밀번호 불일치");
		}
	}

	// (+추가)
	// - Refresh Token으로 로그인 하는 기능
	// - 보안이 매우 취약한 기능이므로 보안을 올리기 위해 각종 장치를 추가
	// - DB검증 등...
	// - Authorization이라는 헤더에 있는 값을 읽어서 검사한 뒤 갱신 처리
	// - 검증할 수 없는 토큰 또는 기타 오류 발생 시 404 처리
	@PostMapping("/refresh")
	public MemberLoginResponseVO refresh(@RequestHeader("Authorization") String refreshToken) {
		// [1] refreshToken이 없거나 Bearer로 시작하지 않으면 안됨
		if (refreshToken == null)
			throw new TargetNotFoundException("토큰 없음");
		if (tokenService.isBearerToken(refreshToken) == false)
			throw new TargetNotFoundException("Bearer 토큰 아님");

		// [2] 토큰에서 정보를 추출
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(refreshToken));
		if (claimVO.getMemberId() == null)
			throw new TargetNotFoundException("아이디 없음");
		if (claimVO.getMemberLevel() == null)
			throw new TargetNotFoundException("등급 없음");

		// [3] 토큰 발급 내역을 조회
		MemberTokenDto memberTokenDto = new MemberTokenDto();
		memberTokenDto.setTokenTarget(claimVO.getMemberId());
		memberTokenDto.setTokenValue(tokenService.removeBearer(refreshToken));
		MemberTokenDto resultDto = memberTokenDao.selectOne(memberTokenDto);
		if (resultDto == null)// 발급내역이 없음
			throw new TargetNotFoundException("발급 내역이 없음");

		// [4] 기존의 리프시 토큰 삭제
		memberTokenDao.delete(memberTokenDto);

		// [5] 로그인 정보 재발급
		MemberLoginResponseVO response = new MemberLoginResponseVO();
		response.setMemberId(claimVO.getMemberId());
		response.setMemberLevel(claimVO.getMemberLevel());
		response.setAccessToken(tokenService.createAccessToken(claimVO));// 재발급
		response.setRefreshToken(tokenService.createRefreshToken(claimVO));// 재발급
		return response;
	}

	// 회원 본인의 정보를 반환하는 기능
	// - 아이디를 변경할 수 없도록 Authorization 헤더에서 정보를 읽어 조회한 뒤 반환
	@GetMapping("/find")
	public MemberDto find(@RequestHeader("Authorization") String accessToken) {
		if (tokenService.isBearerToken(accessToken) == false)
			throw new TargetNotFoundException("유효하지 않은 토큰");
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(accessToken));

		MemberDto memberDto = memberDao.selectOne(claimVO.getMemberId());
		if (memberDto == null)
			throw new TargetNotFoundException("존재하지 않는 회원");

		memberDto.setMemberPw(null);// 비밀번호 제거

		return memberDto;
	}
}
