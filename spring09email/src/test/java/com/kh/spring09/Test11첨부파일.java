package com.kh.spring09;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test11첨부파일 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		//첨부파일은 마임메세지로만 전송이 가능하다.
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = 
				new MimeMessageHelper(message, true, "UTF-8");
		
		ClassPathResource resource = new ClassPathResource("templates/email-template.html");
		File target = resource.getFile();
		
		Document document = Jsoup.parse(target);
		
		//이메일 정보 작성
		helper.setTo("minseok916@gmail.com");
		helper.setSubject("첨부파일 테스트");
		helper.setText(document.toString(), true);
		
		//파일 로드 및 첨부
		ClassPathResource attach1 = new ClassPathResource("static/images/qhshqhsh.png");
		ClassPathResource attach2 = new ClassPathResource("static/images/보노보노총합.gif");
		helper.addAttachment("첨부1", attach1);//별도로 이름을 설정
		helper.addAttachment("첨부2", attach2);
		helper.addAttachment(attach1.getFilename(), attach1);//파일명으로 이름을 설정
		helper.addAttachment(attach2.getFilename(), attach2);
		
		
		//전송
		sender.send(message);
	}
}
