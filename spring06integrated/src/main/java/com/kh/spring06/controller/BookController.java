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

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.dto.BookDto;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookDao dao;
	
//	등록 - 파라미터에 있는 도서정보를 받아서 DAO에게 전달
	@GetMapping("/save")
	public String save() {
		return "/WEB-INF/views/book/save.jsp";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute BookDto dto) {
		dao.insert(dto);
		return "redirect:saveComplete";
	}
	
	@RequestMapping("/saveComplete")
	public String saveComplete() {
		return "WEB-INF/views/book/save2.jsp";
	}
	
//	목록 - 파라미터에 존재하는 검색데이터(column, keyword)를 받아 목록or검색
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String column,
								@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<BookDto> list = isSearch ?
						dao.selectList(column, keyword) : dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		if(list.isEmpty()) {
			buffer.append("데이터가 존재하지 않습니다");
		}
		else {
			buffer.append("데이터 개수 : " + list.size() + "<br>");
			for(BookDto dto : list) {
				buffer.append(dto.toString());
				buffer.append("<br>");
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/views/book/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			@RequestParam int bookId) {
		BookDto dto = dao.selectOne(bookId);
		model.addAttribute("dto", dto);
		if(dto == null) {
			return "존재하지 않는 도서 번호";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("도서번호 : " + dto.getBookId() + "<br>");
		buffer.append("도서명 : " + dto.getBookTitle() + "<br>");
		buffer.append("지은이 : " + dto.getBookAuthor() + "<br>");
		buffer.append("출판일 : " + dto.getBookPublicationDate() + "<br>");
		buffer.append("판매가 : " + dto.getBookPrice() + "<br>");
		buffer.append("출판사 : " + dto.getBookPublisher() + "<br>");
		buffer.append("페이지 : " + dto.getBookPageCount() + "<br>");
		buffer.append("장르 : " + dto.getBookGenre() + "<br>");
		return "/WEB-INF/views/book/detail.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute BookDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "/WEB-INF/views/book/edit.jsp";
		}
		else {
			return "/WEB-INF/views/book/noBookId.jsp";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		boolean result = dao.delete(bookId);
		return "redirect:list";
	}
	
}
