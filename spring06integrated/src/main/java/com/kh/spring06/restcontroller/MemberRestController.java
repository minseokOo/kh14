package com.kh.spring06.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.MemberDto;

// 회원에 대한 비동기 통신을 처리하기 위한 컨트롤러
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	
	@Autowired
	private MemberDao memberDao;
	
	//아이디 중복 검사
	@PostMapping("/checkId")
	public boolean checkId(@RequestParam String memberId){
		MemberDto memberDto = memberDao.selectOne(memberId);
		return memberDto == null;
//		if(memberDto == null) {
//			return true;
//		}
//		else {
//			return false;
//		}
		
	}
			
}
