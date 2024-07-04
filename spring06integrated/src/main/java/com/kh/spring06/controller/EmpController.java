package com.kh.spring06.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.dao.EmpDao;
import com.kh.spring06.dto.EmpDto;


@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpDao dao;
	
	// 이 컨트롤러에서 파라미터를 처리하는 규칙을 변경
	// - 비어있는 문자열("")을 null로 변환하도록 처리
	// - 장점 : 직접 메소드를 고치지 않고 처리 방식을 변경할 수 있다.
	// - 단점 : 다른 컨트롤러에 또 써야한다.
	// - 해결책 : 모든 컨트롤러에 적용할 수 있는 신규 도구 사용(ControllerAdvice)
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder 에 어떤 도구를 설정 하느냐에 따라 처리 규칙이 바뀜
//		binder.registerCustomEditor(자료형, 도구);
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	}
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/emp/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute EmpDto dto) {
		dao.insert(dto);
		return "redirect:addFinish";
	}
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/emp/addFinish.jsp";
	}
	
//	
//	@RequestMapping("/edit")
//	public String edit(@ModelAttribute EmpDto dto) {
//		dao.edit(dto);
//		return "변경 완료";
//	}
//	@RequestMapping("/remove")
//	public String remove(@RequestParam int empNo) {
//		boolean result = dao.remove(empNo);
//		if(result) {
//		return "삭제 완료";
//		}
//		else {
//			return "존재하지 않는 번호";
//		}
//	}
	
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String column,
								@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<EmpDto> list = isSearch ? 
				dao.selectList(column, keyword) : dao.selectList() ;
		
		model.addAttribute("list", list);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
	return "/WEB-INF/views/emp/list.jsp";
		
	}
	
	//상세 페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam int empNo, Model model) {
		EmpDto dto = dao.selectOne(empNo);
			model.addAttribute("dto", dto);
			return "/WEB-INF/views/emp/detail.jsp";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int empNo) {
		boolean result = dao.remove(empNo);
		return "redirect:list";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int empNo) {
		EmpDto dto = dao.selectOne(empNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/emp/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute EmpDto dto) {
		boolean result = dao.edit(dto);
		return "redirect:detail?empNo="+dto.getEmpNo();
	}
}
