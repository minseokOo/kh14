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
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
	//로그인
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
//	HttpSession(세션)
//	- 컨트롤러의 매개변수로 선언한 하면 이용할 수 있는 key=value 저장소
//	- 사용자별로 정보가 따로 관리되기 때문에 사용자에 대한 정보를 저장
//	- 저장된 정보는 별도로 삭제하지 않는한 일정시간 동안 유지됨(기본 30분)
//	- 한번이라도 새로운 페이지를 요청하면 30분이 다시 충전됨
	@PostMapping("/login")
	public String login(@RequestParam String memberId, 
								@RequestParam String memberPw, 
								HttpSession session) {
//	public String login(@ModelAttribute MemberDto memberDto) {
		//1. 아이디에 해당하는 정보(MemberDto)를 불러온다
		// -> 없으면 나가! (실패)
		//2. 1번에서 불러온 정보(MemberDto)와 비밀번호를 비교한다
		// -> 안맞으면 나가! (실패)
		//3. 1,2번에서 쫓겨나지 않았다면 성공으로 간주
		
		//1
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) return "redirect:login?error";//redirect는 무조건 GET으로 감
		
		//2
		boolean isValid = memberPw.equals(memberDto.getMemberPw());
		if(isValid == false) return "redirect:login?error";
		
		//3
		//session.setAttribute("이름", 값);
		session.setAttribute("createdUser", memberId);
		session.setAttribute("createdLevel", memberDto.getMemberLevel());
		memberDao.updateMemberLogin(memberId);
		return "redirect:/";//홈으로 이동
	}
	
	//로그아웃(회원 전용 기능)
	//- HttpSession에 로그인 시 저장한 값을 삭제하면 끝
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("createdUser");
		session.removeAttribute("createdLevel");
		//session.invalidate();//세션 만료(소멸) 명령 - 권장하지 않음
		return "redirect:/";
	}
	
	//마이페이지(회원 전용 기능)
	//- 현재 사용자의 정보를 HttpSession에서 얻어내야 구현할 수 있는 기능
	//- 정보가 없는 상황(비회원)에 대한 처리는 여기서 하지 않는다(일괄처리)
	//- 꺼낼 때 원래 형태로 다운캐스팅이 필요하다
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String createdUser = (String) session.getAttribute("createdUser");
		MemberDto memberDto = memberDao.selectOne(createdUser);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	//비밀번호 변경
	
	@GetMapping("/password")
	public String password() {
		return "/WEB-INF/views/member/password.jsp";
	}
	@PostMapping("/password")
	public String password(@RequestParam String currentPw,
												@RequestParam String changePw,
												HttpSession session) {
		//아이디 추출
		String memberId = (String)session.getAttribute("createdUser");
		//현재 사용자의 정보 추출
		MemberDto memberDto = memberDao.selectOne(memberId);
		//비밀번호 비교
		boolean isValid = memberDto.getMemberPw().equals(currentPw);
		if(!isValid) return "redirect:password?error";
		//비밀번호 변경
		memberDao.updateMemberPw(memberId, changePw);
		//(+추가) 만약 비밀번호 변경 시 로그아웃 처리를 하려면
		//session.removeAttribute("createdUser");
		//완료 페이지로 추방
		return "redirect:passwordFinish";
		
	}
	@RequestMapping("/passwordFinish")
	public String passwordFinish() {
		return "/WEB-INF/views/member/passwordFinish.jsp";
	}
	
	//개인정보 변경
	@GetMapping("/change")
	public String change(HttpSession session, Model model) {
		//아이디 추출
		String memberId = (String)session.getAttribute("createdUser");
		//회원 정보 추출
		MemberDto memberDto = memberDao.selectOne(memberId);
		//화면에 전달
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/change.jsp";
	}
	@PostMapping("/change")
	public String change(HttpSession session, @ModelAttribute MemberDto inputDto) {
		//기존 정보를 조회 
		String memberId = (String)session.getAttribute("createdUser");
		MemberDto findDto = memberDao.selectOne(memberId);
		//비밀번호 검사
		boolean isValid = inputDto.getMemberPw().equals(findDto.getMemberPw());
		if(!isValid) return "redirect:change?error";
		//변경 처리
		inputDto.setMemberId(memberId);//아이디 추가
		memberDao.updateMember(inputDto);
		return "redirect:mypage";
	}
	@GetMapping("/exit")
	public String exit(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("createdUser");
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/exit.jsp";
	}
	
	@PostMapping("/exit")
	public String exit(@ModelAttribute MemberDto inputDto, HttpSession session) {
	String memberId = (String)session.getAttribute("createdUser");
	MemberDto findDto = memberDao.selectOne(memberId);
	boolean isValid = inputDto.getMemberPw().equals(findDto.getMemberPw());
	if(!isValid) return "redirect:exit?error";
	inputDto.setMemberId(memberId);
	memberDao.deleteMember(inputDto);
	session.removeAttribute("createdUser");
	session.removeAttribute("createdLevel");
	return "redirect:goodbye";
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "/WEB-INF/views/member/goodbye.jsp";
	}
	
	
	
	
	
	
	
	
}
