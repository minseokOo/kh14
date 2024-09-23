package com.example.restapi.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Rest API!";
	}
		
	//(ex) 두 개의 숫자를 더해서 결과를 반환하는 매핑
	@GetMapping("/plus")
	public int plus(@RequestParam int a, @RequestParam int b) {
		return a + b;
	}
}
