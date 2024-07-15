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

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dto.BoardDto;
import com.kh.spring06.error.TargetNotFoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	
	//글 목록
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<BoardDto> list = isSearch ? 
				boardDao.selectList(column, keyword) : boardDao.selectList();
		
		model.addAttribute("list", list);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/views/board/list.jsp";
	}
	
	
	//글 작성
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		String createdUser = (String)session.getAttribute("createdUser");
		//시퀀스 번호를 먼저 생성하도록 지시
		int seq = boardDao.sequence();
		boardDto.setBoardWriter(createdUser);
		boardDto.setBoardNo(seq);
		boardDao.write(boardDto);
		return "redirect:read?boardNo=" + seq;
	}
//	@RequestMapping("/writeFinish")
//	public String writeFinish() {
//		return "/WEB-INF/views/board/writeFinish.jsp";
//	}
	
	//읽기
	@RequestMapping("/read")
	public String read(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/read.jsp";
	}
	
	//수정
	@GetMapping("/update")
	public String update(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/update.jsp";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto boardDto) {
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		boardDao.update(boardDto);
		return "redirect:read?boardNo="+boardDto.getBoardNo();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		boardDao.delete(boardNo);
		return "redirect:list";
	}
}

