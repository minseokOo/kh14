package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring06.dao.PoketmonDao;
import com.kh.spring06.dto.PoketmonDto;

@Controller
@RequestMapping("/poketmon")
public class PoketmonController {
	
	@Autowired
	private PoketmonDao dao;
	
	
	
//	@RequestMapping("/insert1")//입력
	@GetMapping("/insert")//GET방식만 처리
	public String insert() {
		return "/WEB-INF/views/poketmon/insert1.jsp";
	}
	
//	@RequestMapping("/insert2")//처리
	@PostMapping("/insert")//POST방식만 처리
	public String insert(@ModelAttribute PoketmonDto dto) {
		dao.insert(dto);
		return "redirect:insertComplete"; //리다이렉트(상대경로)
	}
	
	@RequestMapping("/insertComplete")//완료
	public String insertComplete() {
		return "/WEB-INF/views/poketmon/insert3.jsp";
	}
	
}
