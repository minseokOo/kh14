package com.kh.spring08.controller;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//비동기 통신(AJAX)을 위한 컨트롤러
//- 화면이 아니라 데이터를 원하는 통신
//- 필연적으로 교차출처(CORS) 이슈가 발생하므로 이를 설정으로 해결
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/test")
public class TestRestController {

	@RequestMapping("/ex01")
	public String ex01() {
		return "Hello AJAX";
	}
	@RequestMapping("/ex02")
	public int ex02() {
		Random r = new Random();
		return r.nextInt(6)+1;
	}
	@RequestMapping("/ex03")
	public int ex03(@RequestParam int birth) {
		int age = LocalDate.now().getYear()-birth+1;
		if(age < 8 || age >= 65) {
			return 0;
		}
		else if(age < 14) {
			return 500;
		}
		else if(age < 20) {
			return 1200;
		}
		else {
			return 1500;
		}
	}
}
