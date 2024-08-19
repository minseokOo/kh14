package com.kh.spring09;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test09외부템플릿 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		//[1] sender를 이용하여 전송 가능한 마임메세지 객체를 생성한다
		MimeMessage message = sender.createMimeMessage();
		
		//[2] 메세지에 정보를 설정해주는 도우미 생성
		MimeMessageHelper helper = 
							new MimeMessageHelper(message, false, "UTF-8");
		
		//[3] 도우미를 통해 메세지에 정보를 설정
		helper.setTo("minseok916@gmail.com");
		helper.setSubject("마임 메세지 테스트");
		
		//외부에 만들어 놓은 HTML 문서를 불러와서 첨부
		//- src에 만든 구성요소들을 쉽게 찾을 수 있도록 ClassPathResource라는 클래스를 제공
		ClassPathResource template = new ClassPathResource("templates/email-template.html");
		File target = template.getFile();
		StringBuffer buffer = new StringBuffer();//문자열 저장소 생성
		Scanner sc = new Scanner(target); //파일을 읽을 수 있는 Scanner 생성
		while(sc.hasNextLine()) {//읽을 수 있는 줄이 있다면
			String line = sc.nextLine(); //한 줄을 읽으세요
			buffer.append(line);//저장소에 추가
			
		}
		sc.close(); //도구 정리
		//[4] 전송
		helper.setText(buffer.toString(), true);
		sender.send(message);
		}
	
}