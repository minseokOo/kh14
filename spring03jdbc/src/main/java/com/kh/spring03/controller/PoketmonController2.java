package com.kh.spring03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring03.dao.PoketmonDao;
import com.kh.spring03.dto.PoketmonDto;

@RestController
@RequestMapping("/poketmon")
public class PoketmonController2 {

	@Autowired
	private PoketmonDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute PoketmonDto dto) {
		dao.insert(dto);
		return "포켓몬스터 등록 완료";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute PoketmonDto dto) {
		boolean result = dao.update(dto);
		
		if(result) {
			return "포켓몬스터 정보 변경 완료";
		}
		else {
			return "존재하지 않는 포켓몬스터 번호";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int poketmonNo) {
		boolean result = dao.delete(poketmonNo);
		if(result) {
			return "포켓몬스터 삭제 완료";
		}
		else {
			return "존재하지 않는 포켓몬스터 번호";
		}
	}

}
