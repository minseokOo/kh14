package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.MemberDto;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	private MemberDao memberDao;
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<MemberDto> list = isSearch? 
				memberDao.selectList(column, keyword) : memberDao.selectList();
		model.addAttribute("list", list);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/views/admin/memberList.jsp";
	}
}
