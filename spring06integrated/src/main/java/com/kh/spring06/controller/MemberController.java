package com.kh.spring06.controller;

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

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	//회원가입
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto)	{
		memberDao.insert(memberDto);
		return "redirect:joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	@GetMapping("/login")
	public String login() {
//		MemberDto dto = memberDao.login(memberId);
		
		return "/WEB-INF/views/member/login.jsp";
	}
	
// HttpSession(세션)
// - 컨트롤러의 매개면수로 선언한 하면 이용할 수 있는 key=value 저장소
// - 사용자별로 정보가 따로 관리되기 때문에 사용자에 대한 정보를 저장
//	- 저장된 정보는 별도로 삭제 하지 않는 이상 일정시간 동안 유지됨(기본 30분)
//	- 한번이라도 새로운 페이지를 요청하면 30분이 다시 충전됨
	
	@PostMapping("/login")
	public String login(@RequestParam String memberId,
										@RequestParam String memberPw, 
										HttpSession session) {
		// 1. 아이디에 해당하는 정보(MemberDto)를 불러온다
		// -> 없다면 실패
		// 2. 1번에서 불러온 정보(MemberDto)와 비밀번호를 비교한다
		// -> 없다면 실패
		// 3. 1,2번에서 실패하지 않았다면 성공으로 간주
		
		// 1.
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) return "redirect:login?error"; //redirect는 무조건 Get으로 감
		
		// 2.
		boolean isValid = memberPw.equals(memberDto.getMemberPw());
		if(isValid == false) return "redirect:login?error";
		
		// 3.
//		session.setAttribute("이름", 값);
		session.setAttribute("createdUser", memberId);
		return "redirect:/"; //홈으로 이동
		
	}
	
	//로그아웃(회원 전용 기능)
	// - HttpSession에 로그인 시 저장한 값을 삭제하면 끝
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("createdUser");
		//session.invalidate();//세션 만료(소멸) 명령 - 권장하지 않음
		return "redirect:/";
	}
	
	//마이페이지(로그인 회원 기능)
	// - 현재 사용자의 정보를 HttpSession에서 얻어내야 구현할 수 있는 기능
	// - 정보가 없는 상황(비회원)에 대한 처리는 여기서 하지 않는다(일괄처리)
	// - 꺼낼 때 원래 형태로 다운캐스팅이 필요하다
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String createdUser = (String) session.getAttribute("createdUser");
		MemberDto memberDto = memberDao.selectOne(createdUser);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	
}
