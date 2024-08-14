package com.kh.spring09;

import java.text.DecimalFormat;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring09.service.EmailService;
import com.kh.spring09.service.RandomService;

@SpringBootTest
public class Test06단문메세지발송 {

	@Autowired
	private EmailService emailService;
	
	@Test
	public void test() {
	
		emailService.sendCert("shwjdgus12345@naver.com");
		
		
	}
}
