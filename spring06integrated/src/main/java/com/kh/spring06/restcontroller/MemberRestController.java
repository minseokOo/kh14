package com.kh.spring06.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.MemberDto;
import com.kh.spring06.service.AttachmentService;
import com.kh.spring06.vo.StatusVO;

import jakarta.servlet.http.HttpSession;

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
	
	@Autowired
	private AttachmentService attachmentService;
	
	//프로필 이미지만 업로드하는 매핑
	@PostMapping("/profile")
	public void profile(HttpSession session, @RequestParam MultipartFile attach) throws IllegalStateException, IOException{
		if(attach.isEmpty()) return;
		
		//아이디 추출
		String memberId = (String)session.getAttribute("createdUser");
		
		// 기존 이미지가 있다면 제거
		try {
			int beforeNo = memberDao.findImage(memberId); // 기존 이미지 번호 찾기
			attachmentService.delete(beforeNo); // 기존 이미지 지우기
		}
		catch(Exception e) {} //예외 발생시 스킵
		
		//첨부파일 저장
		int attachmentNo = attachmentService.save(attach);
		
		//아이디와 신규 이미지를 연결
		memberDao.connect(memberId, attachmentNo);
	}

}
