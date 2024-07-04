package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.dto.BookDto;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookDao dao;
	
//	등록 - 파라미터에 있는 도서정보를 받아서 DAO에게 전달
	@RequestMapping("/save")
	public String save(@ModelAttribute BookDto dto) {
		dao.insert(dto);
		return "도서 등록 완료";
	}
	
//	목록 - 파라미터에 존재하는 검색데이터(column, keyword)를 받아 목록or검색
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column,
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
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId) {
		BookDto dto = dao.selectOne(bookId);

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
		return buffer.toString();
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute BookDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "도서 정보 변경 완료";
		}
		else {
			return "존재하지 않는 도서 번호";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		boolean result = dao.delete(bookId);
		if(result) {
			return "도서 정보 삭제 완료";
		}
		else {
			return "존재하지 않는 도서 번호";
		}
	}
	
}
