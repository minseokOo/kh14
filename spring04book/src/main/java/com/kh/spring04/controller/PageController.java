package com.kh.spring04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/insert.jsp";
	}

}