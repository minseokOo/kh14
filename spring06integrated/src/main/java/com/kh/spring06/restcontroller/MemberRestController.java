package com.kh.spring06.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.MemberDto;
import com.kh.spring06.vo.StatusVO;

// 회원에 대한 비동기 통신을 처리하기 위한 컨트롤러
@CrossOrigin(origins = { "http://127.0.0.1:5500" })
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;

	// 아이디 중복 검사
	@PostMapping("/checkId")
	public boolean checkId(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		return memberDto == null;
//		if(memberDto == null) {
//			return true;
//		}
//		else {
//			return false;
//		}

	}

	// 닉네임 중복 검사
	@PostMapping("/checkNickname")
	public boolean checkNickname(@RequestParam String memberNickname) {
		MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
		return memberDto == null;
	}

	@PostMapping("/status")
	public List<StatusVO> status() {
		return memberDao.statusByMemberLevel();
	}

}
