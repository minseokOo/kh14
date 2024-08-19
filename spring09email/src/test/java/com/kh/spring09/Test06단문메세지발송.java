package com.kh.spring09;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring09.service.EmailService;

@SpringBootTest
public class Test06단문메세지발송 {

	@Autowired
	private EmailService emailService;
	
	@Test
	public void test() {
	
		emailService.sendCert("minseok916@gmail.com");
		
		
	}
}
