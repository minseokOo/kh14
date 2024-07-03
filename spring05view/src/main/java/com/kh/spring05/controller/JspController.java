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
	
	@RequestMapping("/test04img")
	public String test04() {
		return "/WEB-INF/views/test04img.jsp";
	}
	
	@RequestMapping("/test05form")
	public String test05form() {
		return "/WEB-INF/views/test05form.jsp";
	}
	
	@RequestMapping("/test06table")
	public String test06table() {
		return "/WEB-INF/views/test06table.jsp";
	}
	
	@RequestMapping("/test07medalist")
	public String test07medalist() {
		return "/WEB-INF/views/test07medalist.jsp";
	}
	
}
