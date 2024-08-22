package com.kh.spring09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dto.CertDto;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private RandomService randomService;
	
	@Autowired
	private CertDao certDao;
	
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
	
}
