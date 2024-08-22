package com.kh.spring10.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {

	@Bean
	public PasswordEncoder encoder() { //김밥 (업캐스팅)
//	public BCryptPasswordEncoder encoder() {//참치김밥
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//원하는 설정을 추가
		return encoder;
	}
}
