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

import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.MemberDto;
import com.kh.spring06.error.TargetNotFoundException;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	private MemberDao memberDao;
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		// 문제점
		// - column에 허락 되지 않은 값(ex : member_pw)이 들어오는 상황이 존재
		
		boolean isSearch = this.checkSearch(column, keyword); //다른 매핑은 못부름
		List<MemberDto> list = isSearch? 
				memberDao.selectList(column, keyword) : memberDao.selectList();
		model.addAttribute("list", list);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/views/admin/memberList.jsp";
	}
	
	// 이 컨트롤러에서 외부에 공개하지 않고 내부에서만 쓰는 메소드
	private boolean checkSearch(String column, String keyword) {
		if(column == null) return false;
		if(keyword == null) return false;
		switch(column) {
		case "member_id":
		case "member_email":
		case "member_nickname":
		case "member_level":
			return true;
		}
		return false;
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null)
			throw new TargetNotFoundException("존재하지 않는 회원 ID");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/adminDetail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotFoundException("존재하지 않는 회원 ID");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/adminEdit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) {
		boolean result = memberDao.updateMemberAdmin(memberDto);
		if(result == false)
			throw new TargetNotFoundException("존재하지 않는 회원 ID");
		return "redirect:detail?memberId="+memberDto.getMemberId();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String memberId) {
		boolean result = memberDao.delete(memberId);
		if(result == false) throw new TargetNotFoundException("존재하지 않는 회원 ID");
		return "redirect:list";
	}
}