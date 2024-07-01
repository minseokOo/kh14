package com.kh.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //사용자에게 화면(view)를 반환하는 컨트롤러
//@RestController // 사용자에게 글자(데이터)를 반환하는 컨트롤러
public class JspController {

	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp"; // 사용자가 받을 화면의 경로
	}
	
	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "WEB-INF/views/test02.jsp";
	}
	
	@RequestMapping("/test03")
	public String test03() {
		return "WEB-INF/views/test03.jsp";
	}
}
