package com.kh.spring03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring03.dao.EmpDao;
import com.kh.spring03.dto.EmpDto;


@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpDao dao;
	
	@RequestMapping("/add")
	public String add(@ModelAttribute EmpDto dto) {
		dao.insert(dto);
		return "등록 완료";
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
