package com.kh.spring06.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring06.configuration.CustomCertProperties;
import com.kh.spring06.dao.BlockDao;
import com.kh.spring06.dao.CertDao;
import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.BlockDto;
import com.kh.spring06.dto.CertDto;
import com.kh.spring06.dto.MemberDto;
import com.kh.spring06.error.TargetNotFoundException;
import com.kh.spring06.service.AttachmentService;
import com.kh.spring06.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BlockDao blockDao;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private EmailService emailService;
	
	//회원가입
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
//	@PostMapping("/join")
//	public String join(@ModelAttribute MemberDto memberDto) {
//		memberDao.insert(memberDto);
//		return "redirect:joinFinish";
//	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto, MultipartFile attach) throws IllegalStateException, IOException {
		// 1. 회원가입
		memberDao.insert(memberDto);
		
		if(attach.isEmpty() == false) {
			// 2. 첨부파일이 있다면 등록
			// 2-1. 시퀀스 생성
			int attachmentNo = attachmentService.save(attach);
			// 3. 회원 이미지에 연결정보 저장
			memberDao.connect(memberDto.getMemberId(), attachmentNo);
			
		}
		
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
// (+추가) remember라는 이름으로 체크박스 값을 수신(체크했으면 not null, 안했으면 null)
	@PostMapping("/login")
	public String login(@RequestParam String memberId, 
								@RequestParam String memberPw, 
								@RequestParam(required = false) String remember, //아이디 저장하기
								HttpSession session, HttpServletResponse response) {
//	public String login(@ModelAttribute MemberDto memberDto) {
		//1. 아이디에 해당하는 정보(MemberDto)를 불러온다
		// -> 없으면 나가! (실패)
		//2. 1번에서 불러온 정보(MemberDto)와 비밀번호를 비교한다
		// -> 안맞으면 나가! (실패)
		//3. 1,2번에서 쫓겨나지 않았다면 차단 여부를 검사
		// -> 차단된 상태면 로그인 불가 페이지로 추방
		//4. 1, 2, 3번에서 쫓겨나지 않았다면 성공으로 간주
		
		//1
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) return "redirect:login?error";//redirect는 무조건 GET으로 감
		
		//2
		boolean isValid = memberPw.equals(memberDto.getMemberPw());
		if(isValid == false) return "redirect:login?error";
		//3
		//차단 확인
		BlockDto blockDto = blockDao.selectLastOne(memberId);
		boolean isBlock = blockDto != null && blockDto.getBlockType().equals("차단");
		if(isBlock) return "redirect:block";
				
		//4
		System.out.println("로그인 성공 : " + memberId);
		//session.setAttribute("이름", 값);
		session.setAttribute("createdUser", memberId);
		session.setAttribute("createdLevel", memberDto.getMemberLevel());
		memberDao.updateMemberLogin(memberId);
		
		// (+추가) 
		// - 로그인 성공 시 remember의 유무에 따라 쿠키를 생성 혹은 삭제
		// - 쿠키의 이름은 saveId로 지어야 하며 값은 로그인한 회원의 아이디를 저장
		if(remember != null) { //아이디 저장하기 O
			Cookie ck = new Cookie("saveId", memberId); //쿠키생성
			ck.setMaxAge(4 * 7 * 24 * 60 * 60); // 4주
			response.addCookie(ck);//사용자에게 발행
		}
		else { //아이디 저장하기 X
			Cookie ck = new Cookie("saveId", memberId);
			ck.setMaxAge(0); // 0초 지속 ( = 삭제 )
			response.addCookie(ck); //사용자에게 발행
		}
		
		
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
		System.out.println("mypage = " + createdUser);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("blockList", blockDao.selectList(createdUser));
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
	try {
		int attachmentNo = memberDao.findImage(memberId);
		attachmentService.delete(attachmentNo);
	}
	catch(Exception e) {}
	finally {
		memberDao.delete(memberId);
	}
	
	session.removeAttribute("createdUser");
	session.removeAttribute("createdLevel");
	return "redirect:goodbye";
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "/WEB-INF/views/member/goodbye.jsp";
	}
	
	@RequestMapping("/block")
	public String block() {
		
		return "/WEB-INF/views/member/block.jsp";
	}
	
	//이미지 찾기
	@RequestMapping("/myImage")
	public String myImage(HttpSession session) {
		try {
		String memberId = (String) session.getAttribute("createdUser");
		
		int attachmentNo = memberDao.findImage(memberId);
		return "redirect:/attach/download?attachmentNo="  + attachmentNo;
		}
		catch (Exception e) {
			return "redirect:/images/user.jpg";
		
		}
	}
	
	@RequestMapping("/image")
	public String image(@RequestParam String memberId) {
		try {
		int attachmentNo = memberDao.findImage(memberId);
		return "redirect:/attach/download?attachmentNo="  + attachmentNo;
		}
		catch (Exception e) {
			return "redirect:/images/user.jpg";
		
		}
	}
	
	//비밀번호 찾기(임시 비밀번호)
	@GetMapping("/findPw")
	public String findPw() {
		return "/WEB-INF/views/member/findPw.jsp";
	}
	
	@PostMapping("/findPw")
	public String findPw(@RequestParam String memberId, 
											@RequestParam String memberEmail) throws IOException, MessagingException {
		//회원 정보 조회
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) {
//			throw new TargetNotFoundException("존재하지 않는 아이디");
			return "redirect:findPw?error";
		}
		
		//이메일 비교
		if(!memberEmail.equals(memberDto.getMemberEmail())) {
			return "redirect:findPw?error";
		}
		
		
		
		//이메일 발송
		emailService.sendTempPw(memberId, memberEmail);
		
		//완료 페이지로 redirect
		return "redirect:findPwFinish";
	}
	
	@RequestMapping("/findPwFinish")
	public String findPwFinish() {
		return "/WEB-INF/views/member/findPwFinish.jsp";
	}
	//비밀번호 찾기 (재설정 링크 방식)
	@GetMapping("/findPw2")
	public String findPw2() {
		return "/WEB-INF/views/member/findPw2.jsp";
	}
	@PostMapping("/findPw2")
	public String findPw2(@RequestParam String memberId, @RequestParam String memberEmail) throws IOException, MessagingException {
		MemberDto memberDto = memberDao.selectOne(memberId);		
		if(memberDto == null) {
			return "redirect:findPw?error";
		}
		//이메일 비교
		if(!memberEmail.equals(memberDto.getMemberEmail())) {
			return "redirect:find?error";
		}
		emailService.sendResetPw(memberId, memberEmail);
		return "redirect:findPw2Finish";
	}
	
	@RequestMapping("/findPw2Finish")
	public String findPw2Finish() {
		
		
		return "/WEB-INF/views/member/findPw2Finish.jsp";
	}
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private CustomCertProperties customCertProperties; 
	
	
	@GetMapping("/resetPw")
	public String resetPw(@ModelAttribute CertDto certDto, @RequestParam String memberId, 
													Model model) {
		boolean isValid = certDao.check(certDto,  customCertProperties.getExpire());
		System.out.println("isValid = " + isValid);
		if(isValid) {
			model.addAttribute("certDto", certDto);
			model.addAttribute("memberId", memberId);
			return "/WEB-INF/views/member/resetPw.jsp";
		}
		else {
			throw new TargetNotFoundException("올바르지 않은 접근");
		}
	}
	@PostMapping("/resetPw")
	public String resetPw(@ModelAttribute CertDto certDto, 
													@ModelAttribute MemberDto memberDto) {
		boolean isValid = certDao.check(certDto, customCertProperties.getExpire());
		if(!isValid) {
			throw new TargetNotFoundException("올바르지 않은 접근");
		}
		//1회만 사용 가능
		certDao.delete(certDto.getCertEmail());
		
		// 비밀번호 변경 처리
		memberDao.updateMemberPw(memberDto.getMemberId(), memberDto.getMemberPw());
		return "redirect:resetPwFinish";
	}
	@RequestMapping("/resetPwFinish")
	public String resetPwFinish() {
		return "/WEB-INF/views/member/resetPwFinish.jsp";
	}
	
}
