package com.kh.spring05.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JstlController {
	
	//만약에 계산된 값을 화면에 전달 하고 싶다면 
	//Model을 매개변수에 선언한 뒤 첨부
	@RequestMapping("/test01")
	public String test01(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		//model에 dice를 첨부(key=value)
		//model.addAttribute("이름", 데이터);
		model.addAttribute("dice", dice);
		
		int lotto = r.nextInt(45) + 1;
		model.addAttribute("lotto", lotto);
		return "/WEB-INF/views/jstl/test01.jsp";
	}
	
}
