package com.kh.spring03.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
}
