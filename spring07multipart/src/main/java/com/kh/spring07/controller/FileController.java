package com.kh.spring07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {
	
	@RequestMapping("/")
	public String home() {
		return "/WEB-INF/views/home.jsp";
		
	}
}
