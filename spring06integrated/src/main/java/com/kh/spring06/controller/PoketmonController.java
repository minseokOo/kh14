package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//목록(검색) 페이지
	// - DB 조회한 결과를 화면에 전달한 뒤 출력 (Model 필요)
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		
		List<PoketmonDto> list = isSearch ? 
				dao.selectList(column, keyword) : dao.selectList();
		
		model.addAttribute("column", column);// 검색분류
		model.addAttribute("keyword", keyword);// 검색어
		model.addAttribute("list", list);
		return "/WEB-INF/views/poketmon/list.jsp";
		
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int poketmonNo, Model model) {
		PoketmonDto dto = dao.selectOne(poketmonNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/poketmon/detail.jsp";
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int poketmonNo) {
		boolean result = dao.delete(poketmonNo);
		return "redirect:list";
	}
	
	// 수정 (입력) - 화면에 띄울 정보를 구해서 전달해야 한다
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int poketmonNo) {
		PoketmonDto dto = dao.selectOne(poketmonNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/poketmon/edit.jsp";
	}
	// 수정 (처리)
	@PostMapping("/edit")
	public String edit(@ModelAttribute PoketmonDto dto) {
		boolean result = dao.update(dto);
		return "redirect:detail?poketmonNo="+dto.getPoketmonNo();
	}
}
