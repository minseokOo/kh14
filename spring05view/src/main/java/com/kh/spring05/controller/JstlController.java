package com.kh.spring05.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//(Q) /test02exchange 주소를 만들고
	// krw라는 이름의 파라미터로 원화 금액을 받은 뒤
	// 이 금액을 달러, 위안, 엔화로 각각 환산한 결과를 화면에 출력
	@RequestMapping("/test02")
	public String test02(Model model) {
		Scanner sc = new Scanner(System.in);
		int KRW = 10000;
		model.addAttribute("KRW", KRW);
		float USD = 0.72f * KRW/1000;
		model.addAttribute("USD", USD);
		float CNY = 5.26f * KRW/1000;
		model.addAttribute("CNY", CNY);
		float JPY = 116.3f * KRW/1000;
		model.addAttribute("JPY", JPY);
		return "/WEB-INF/views/jstl/test02exchange.jsp";
	}
	
	//(Q) /test03goodbye 페이지를 만들고
	// 접속하면 수료까지 남은 일 수를 계산하여 출력
	@RequestMapping("/test03")
	public String test03(Model model, @RequestParam(required=false, defaultValue = "2024-11-12") String end) {
		LocalDate now = LocalDate.now();
		LocalDate lastDay = LocalDate.parse(end);
		model.addAttribute("now", now);
		model.addAttribute("lastDay", lastDay);
//		int yearComparison = Integer.compare(lastDay.getYear(), now.getYear());
//	    model.addAttribute("yearComparison", yearComparison);
//	    int monthComparison = Integer.compare(lastDay.getMonthValue(), now.getMonthValue());
//	    model.addAttribute("monthComparison", monthComparison);
//		int compare = lastDay.compareTo(now);
//		model.addAttribute("compare", compare);
		Period period = Period.between(now, lastDay);
		model.addAttribute("period", period);
		return "/WEB-INF/views/jstl/test03goodbye.jsp";
	}
	
	@RequestMapping("/test04jstl")
	public String test04jstl() {
		return "/WEB-INF/views/jstl/test04jstl.jsp";
	}
	
}
