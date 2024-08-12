package com.kh.spring06.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.ReplyDao;
import com.kh.spring06.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {

	@Autowired
	private ReplyDao replyDao;
	
	@PostMapping("/write")
	public void write(@ModelAttribute ReplyDto replyDto, HttpSession session){
		//step 1 : 시퀀스 번호를 생성한다.
		int seq = replyDao.sequence();
		
		//step 2 : 작성자 정보를 불러온다.
		String memberId = (String)session.getAttribute("createdUser");
		
		//step 3 : 정보를 설정한다.
		replyDto.setReplyNo(seq);
		replyDto.setReplyWriter(memberId);
		
		//step 4 - 등록
		replyDao.insert(replyDto);
		
	}
}
