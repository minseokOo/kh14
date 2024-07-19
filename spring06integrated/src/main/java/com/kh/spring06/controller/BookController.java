package com.kh.spring06.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.dto.BookDto;
import com.kh.spring06.error.TargetNotFoundException;
import com.kh.spring06.service.AttachmentService;
import com.kh.spring06.vo.PageVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AttachmentService attachmentService;
	
	
//	등록 - 파라미터에 있는 도서정보를 받아서 DAO에게 전달
	@GetMapping("/save")
	public String save() {
		return "/WEB-INF/views/book/save.jsp";
	}
	
//	@PostMapping("/save")
//	public String save(@ModelAttribute BookDto dto) {
//		bookDao.insert(dto);
//		return "redirect:saveComplete";
//	}
	@Transactional
	@PostMapping("/save")
	public String save(@ModelAttribute BookDto bookDto, 
			@RequestParam List<MultipartFile> attachList) throws IllegalStateException, IOException {
		//도서 등록
		int bookId = bookDao.sequence();
		bookDto.setBookId(bookId);
		bookDao.insertWithSequence(bookDto);
		
		//파일 등록
		for(MultipartFile attach : attachList) {
			if(attach.isEmpty()) continue;
			
			int attachmentNo = attachmentService.save(attach);
			bookDao.connect(bookId, attachmentNo);
		}
		return  "redirect:list";
	}
	
//	@RequestMapping("/saveComplete")
//	public String saveComplete() {
//		return "/WEB-INF/views/book/save2.jsp";
//	}
	
//	목록 - 파라미터에 존재하는 검색데이터(column, keyword)를 받아 목록or검색
//	@RequestMapping("/list")
//	public String list(Model model,
//			@RequestParam(required = false) String column,
//								@RequestParam(required = false) String keyword) {
//		boolean isSearch = column != null && keyword != null;
//		List<BookDto> list = isSearch ?
//						dao.selectList(column, keyword) : dao.selectList();
//		
//		StringBuffer buffer = new StringBuffer();
//		if(list.isEmpty()) {
//			buffer.append("데이터가 존재하지 않습니다");
//		}
//		else {
//			buffer.append("데이터 개수 : " + list.size() + "<br>");
//			for(BookDto dto : list) {
//				buffer.append(dto.toString());
//				buffer.append("<br>");
//			}
//		}
//		model.addAttribute("list", list);
//		model.addAttribute("column", column);
//		model.addAttribute("keyword", keyword);
//		return "/WEB-INF/views/book/list.jsp";
//	}
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("pageVO") PageVO pageVO, Model model) {
		model.addAttribute("list", bookDao.selectListByPaging(pageVO));
		pageVO.setCount(bookDao.countByPaging(pageVO));
		return "/WEB-INF/views/book/list2.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			@RequestParam int bookId) {
		BookDto dto = bookDao.selectOne(bookId);
		if(dto == null) {
			throw new TargetNotFoundException();
		}
		model.addAttribute("dto", dto);
		
		//(추가) 이 도서의 이미지 번호들을 조회하여 전달.
		List<Integer> images = bookDao.findImages(bookId);
		model.addAttribute("images", images);
		return "/WEB-INF/views/book/detail.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute BookDto dto) {
		boolean result = bookDao.update(dto);
		if(result) {
			return "/WEB-INF/views/book/noBookId.jsp";
		}
		else {
			return "/WEB-INF/views/book/edit.jsp";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		boolean result = bookDao.delete(bookId);
		return "redirect:list";
	}
	
	
	
}
