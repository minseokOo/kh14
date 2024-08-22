package com.kh.spring06.service;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring06.dao.CertDao;
import com.kh.spring06.dao.MemberDao;
import com.kh.spring06.dto.CertDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private RandomService randomService;
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private MemberDao memberDao;
	
	//인증 메일 발송 서비스
	public void sendCert(String email){
		//인증 번호 생성
		String value = randomService.generateNumber(6);
		//메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보교육원] 인증번호 안내");
		message.setText("인증번호는 " + value +"입니다.");
		message.setCc();
		
		//전송
		sender.send(message);
		
		//DB 기록 남기기
		certDao.delete(email);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(email);
		certDto.setCertNumber(value);
		certDao.insert(certDto);
	}
	
	public void sendCert2(String email) throws IOException, MessagingException {
		//인증번호 생성
		String value = randomService.generateNumber(6);
		
		//메세지 생성
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		helper.setTo(email);
		helper.setSubject("[나의 홈페이지] 인증번호 안내");
		
		ClassPathResource resource = new ClassPathResource("templates/cert.html");
		File target = resource.getFile();
		Document document = Jsoup.parse(target, "UTF-8");
		Element number = document.getElementById("cert-number");
		number.text(value);//OTP 번호를 텍스트로 설정
		
		helper.setText(document.toString(), true);
		
		//메세지 전송
		sender.send(message);
		
		//DB 기록 남기기
		certDao.delete(email);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(email);
		certDto.setCertNumber(value);
		certDao.insert(certDto);
	}
	
	//임시 비밀번호 발급 및 메일 전송
	public void sendTempPw(String memberId, String memberEmail) throws IOException, MessagingException {
		//임시 비밀번호 발급
		String tempPassword = randomService.generateString(12);
		memberDao.updateMemberPw(memberId, tempPassword);
		
		//이메일 템플릿 불러와 정보 설정 후 발송
		ClassPathResource resource = new ClassPathResource("templates/temp-pw.html");
		File target = resource.getFile();
		Document document = Jsoup.parse(target);
		Element element = document.getElementById("temp-password");
		element.text(tempPassword);
		
		//메세지 생성
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		helper.setTo(memberEmail);
		helper.setSubject("[나의 홈페이지] 임시 비밀번호 안내");
		helper.setText(document.toString(), true);
		
		//메세지 발송
		sender.send(message);
	}
	
	//비밀번호 재설정 메일 발송 기능
	public void sendResetPw(String memberId, String memberEmail) throws IOException, MessagingException {
		
		ClassPathResource resource = new ClassPathResource("templates/reset-pw.html");
		File target = resource.getFile();
		Document document = Jsoup.parse(target);
		
		Element memberIdWrapper = document.getElementById("member-id");
		memberIdWrapper.text(memberId);
		
		//돌아올 링크 주소를 생성하는 코드
		//인증번호 생성
		String certNumber = randomService.generateNumber(6);
		certDao.delete(memberEmail);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(memberEmail);
		certDto.setCertNumber(certNumber);
		certDao.insert(certDto);
		
		//접속 주소 생성 : 도구를 이용하여 현재 실행중인 주소를 자동으로 읽어오도록 처리
//		String url = "http://localhost:8080/member/resetPw"
//				+ "?certNumber="+certNumber+"&certEmail="+memberEmail
//				+ "&memberId="+memberId;
		String url = ServletUriComponentsBuilder
								.fromCurrentContextPath()//http://localhost:8080
								.path("/member/resetPw")//나머지 경로
								.queryParam("certNumber", certNumber)//파라미터
								.queryParam("certEmail", memberEmail)//파라미터
								.queryParam("memberId", memberId)//파라미터
								.build().toUriString();//문자열 변환
		
		Element resetUrlWrapper = document.getElementById("reset-url");
		resetUrlWrapper.attr("href", url);
	
	//메세지 생성
	MimeMessage message = sender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
	helper.setTo(memberEmail);
	helper.setSubject("비밀번호 재설정 안내");
	helper.setText(document.toString(), true);
	
	sender.send(message);
	}
}
