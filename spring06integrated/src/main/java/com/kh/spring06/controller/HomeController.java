package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.dao.MemberDao;

import jakarta.servlet.http.HttpSession;

@Controller
//공용주소 없음
public class HomeController {
	@Autowired
	private MemberDao memberDao;
	

	@RequestMapping("/")//가장 짧은 주소
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
	
	//이미지 찾기
		@RequestMapping("/myImage")
		public String myImage(HttpSession session) {
			try {
			String memberId = (String) session.getAttribute("createUser");
			int attachmentNo = memberDao.findImage(memberId);
			return "redirect:/attach/download?attachmentNo="  + attachmentNo;
			}
			catch (Exception e) {
				return "redirect:/images/user.jpg";
			
			}
		}
		
		@RequestMapping("/image")
		public String image(@RequestParam String memberId) {
			try {
			int attachmentNo = memberDao.findImage(memberId);
			return "redirect:/attach/download?attachmentNo="  + attachmentNo;
			}
			catch (Exception e) {
				return "redirect:/images/user.jpg";
			
			}
		}
}
