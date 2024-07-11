package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring06.dao.EmpDao;
import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dao.PoketmonDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PoketmonDao poketmonDao;
	@Autowired
	private EmpDao empDao;
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/admin/home.jsp";
	}
	
	//데이터 현황 페이지
	@RequestMapping("/status")
	public String status(Model model) {
		model.addAttribute("poketmonStatusList",  poketmonDao.status());
		model.addAttribute("empDeptStatusList", empDao.statusByEmpDept());
		model.addAttribute("empRankStatusList", empDao.statusByEmpRank());
		model.addAttribute("memberLevelStatusList", memberDao.statusByMemberLevel());
		return "/WEB-INF/views/status.jsp";
	}
}
