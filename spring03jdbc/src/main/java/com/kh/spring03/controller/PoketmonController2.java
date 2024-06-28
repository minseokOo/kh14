package com.kh.spring03.controller;

import java.util.List;

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
	
	//조회, 검색 페이지
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		//boolean isList = column == null || keyword == null;
		boolean isSearch = column != null && keyword != null;
		
		//List<poketmonDto> list = 목록결과 or 검색결과;
		List<PoketmonDto> list = isSearch ?
				dao.selectList(column, keyword) : dao.selectList();
		
		//출력할 문자열 생성
		StringBuffer buffer = new StringBuffer();
		for(PoketmonDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>"); //줄바꿈
		}
		return buffer.toString();
	}

}
