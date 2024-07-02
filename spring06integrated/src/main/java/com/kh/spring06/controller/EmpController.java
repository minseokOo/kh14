package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.dao.EmpDao;
import com.kh.spring06.dto.EmpDto;


@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpDao dao;
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/emp/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute EmpDto dto) {
		dao.insert(dto);
		return "redirect:addFinish";
	}
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/emp/addFinish.jsp";
	}
	
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute EmpDto dto) {
		dao.edit(dto);
		return "변경 완료";
	}
	@RequestMapping("/remove")
	public String remove(@RequestParam int empNo) {
		boolean result = dao.remove(empNo);
		if(result) {
		return "삭제 완료";
		}
		else {
			return "존재하지 않는 번호";
		}
	}
	
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		
		List<EmpDto> list = isSearch ?
				dao.selectList(column, keyword) : dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		for(EmpDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
}
