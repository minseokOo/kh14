package com.spring12.mybatis.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.mybatis.dao.MemberDao;
import com.spring12.mybatis.dto.MemberDto;
import com.spring12.mybatis.error.TargetNotFoundException;
import com.spring12.mybatis.service.TokenService;
import com.spring12.mybatis.vo.MemberClaimVO;
import com.spring12.mybatis.vo.MemberComplexRequestVO;
import com.spring12.mybatis.vo.MemberComplexResponseVO;
import com.spring12.mybatis.vo.MemberLoginRequestVO;
import com.spring12.mybatis.vo.MemberLoginResponseVO;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private TokenService tokenService;
	
	// 여태까지 배운대로라면 복합 검색도 GET으로 구현해야 한다.
	// 하지만 보내야 하는 데이터가 너무 많아서 GET으로 구현하는 것은 어려움이 있다.
	// 해결을 위해 HTTP BODY를 가지는 방식 중 POST를 사용한다.
	@PostMapping("/search") // 회원가입과 구분하기 위해 주소 규칙을 깬다
	public MemberComplexResponseVO search(@RequestBody MemberComplexRequestVO vo) {

		int count = memberDao.complexSearchCount(vo);
			//마지막 = 페이징을 안쓰는 경우 or 검색개수가 종료번호보다 작거나 같은 경우
		boolean last = vo.getEndRow() == null || count <= vo.getEndRow();

		MemberComplexResponseVO response = new MemberComplexResponseVO();
		response.setMemberList(memberDao.complexSearch(vo));
		response.setCount(count);
		response.setLast(last);
		return response;
	}

	@PostMapping("/login")
	public MemberLoginResponseVO login(@RequestBody MemberLoginRequestVO vo) {
		
		MemberDto memberDto = memberDao.selectOne(vo.getMemberId());
		if(memberDto == null) {
			throw new TargetNotFoundException("아이디 없음");
		}
			boolean isValid = vo.getMemberPw().equals(memberDto.getMemberPw());//암호화
			
			if(isValid) {//로그인 성공
				MemberLoginResponseVO response = new MemberLoginResponseVO();
				//아이디, 등급
				response.setMemberId(memberDto.getMemberId());//아이디
				response.setMemberLevel(memberDto.getMemberLevel()); //등급
				MemberClaimVO claimVO = new MemberClaimVO();
				claimVO.setMemberId(memberDto.getMemberId());
				claimVO.setMemberLevel(memberDto.getMemberLevel());
				response.setAccessToken(tokenService.create(claimVO));//액세스 토큰
				
				return response;
			}
			else {//로그인 실패
				throw new TargetNotFoundException("비밀번호 불일치");
			}
		
	}
}
