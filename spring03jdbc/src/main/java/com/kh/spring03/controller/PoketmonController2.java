package com.kh.spring03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poketmon2")
public class PoketmonController2 {

	@RequestMapping("/insert")
	public String insert() {
		return "포켓몬스터 등록 완료";
	}
	
}
