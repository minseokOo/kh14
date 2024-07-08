package com.kh.spring06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//공용주소 없음
public class HomeController {

	@RequestMapping("/")//가장 짧은 주소
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}

}
