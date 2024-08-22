package com.kh.spring06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
//공용주소 없음
public class HomeController {
	
	// 스프링에서 쿠키(cookie)를 읽으려면
	// [1] HttpServletRequest를 직접 조사하여 쿠키를 찾아내는 방법 (반복문)
	// [2] Spring에서 제공하는 @CookieValue를 사용하는 방법
	@RequestMapping("/")//가장 짧은 주소
	public String home(
			//visit라는 이름의 쿠키에 들어있는 값을 가져오세요
			@CookieValue(required = false) String visit, 
			Model model, HttpServletResponse response) {
		// (+추가) 사용자가 얼마만에 방문했는지를 계산
		//System.out.println("visit = " + visit);
		if(visit != null) {
			long period = System.currentTimeMillis() - Long.parseLong(visit);
//			System.out.println("방문 텀 = " + period);
			boolean isLongTimeNoSee = period >= 1L * 60 * 1000;
			model.addAttribute("isLongTimeNoSee", isLongTimeNoSee);
		}
		
		//(+추가) 현재 사용자의 방문시각을 쿠키에 기록하도록 처리
		long current = System.currentTimeMillis();
		Cookie ck = new Cookie("visit", String.valueOf(current));
		ck.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(ck);
		
		return "/WEB-INF/views/home.jsp";
	}
	
	
	
}
