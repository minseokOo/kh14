package com.kh.spring09;

import java.text.DecimalFormat;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring09.service.RandomService;

@SpringBootTest
public class Test05단문메세지발송 {

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private RandomService randomService;
	
	@Test
	public void test() {
		
		
		//수신자(to), 제목(subject), 내용(text), 참조(cc), 숨은참조(bcc)
		String value = randomService.generateNumber(6);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("minseok916@gmail.com");
		message.setSubject("[KH정보교육원] 인증번호 안내");
		message.setText("인증번호는 " + value +"입니다.");
		message.setCc();
		
		//전송
		sender.send(message);
	}
}
