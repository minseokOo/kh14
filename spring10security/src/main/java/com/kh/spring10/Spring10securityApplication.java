package com.kh.spring10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//모든 시스템에 Spring Security가 자동 적용되는 것을 방지하도록 설정
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Spring10securityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring10securityApplication.class, args);
	}

}
