package com.spring12.mybatis.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.mybatis.dao.MemberDao;
import com.spring12.mybatis.dto.MemberDto;
import com.spring12.mybatis.vo.MemberComplexRequestVO;
import com.spring12.mybatis.vo.MemberComplexResponseVO;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	// 여태까지 배운대로라면 복합 검색도 GET으로 구현해야 한다.
	// 하지만 보내야 하는 데이터가 너무 많아서 GET으로 구현하는 것은 어려움이 있다.
	// 해결을 위해 HTTP BODY를 가지는 방식 중 POST를 사용한다.
	@PostMapping("/search")//회원가입과 구분하기 위해 주소 규칙을 깬다
	public List<MemberDto> search(@RequestBody MemberComplexRequestVO vo){
		MemberComplexResponseVO response = new MemberComplexRequestVO();
		response.setMemberList(memberDao.complexSearch(vo));
		return response;
	}
	
}
