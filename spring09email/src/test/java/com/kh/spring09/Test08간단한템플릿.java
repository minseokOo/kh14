package com.kh.spring09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test08간단한템플릿 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		//[1] sender를 이용하여 전송 가능한 마임메세지 객체를 생성한다
		MimeMessage message = sender.createMimeMessage();
		
		//[2] 메세지에 정보를 설정해주는 도우미 생성
		MimeMessageHelper helper = 
							new MimeMessageHelper(message, false, "UTF-8");
		
		//[3] 도우미를 통해 메세지에 정보를 설정
		helper.setTo("minseok916@gmail.com");
		helper.setSubject("마임 메세지 테스트");
		
		//문자열을 합성해서 HTML화면을 제작해보자!
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div style='padding:20px; border:2px solid black;'>");
		buffer.append("<h1>오늘의 운세</h1>");
		buffer.append("<p>");
		buffer.append("오늘은 하시는 모든 일이 뜻대로 잘 풀리는 날입니다!");
		buffer.append("<br>");
		buffer.append("오늘 하루 화이팅하세요!");
		buffer.append("</p>");
		buffer.append("</div>");
		
		helper.setText(buffer.toString(), true);
		
		//[4] 전송
		sender.send(message);
	}
	
}