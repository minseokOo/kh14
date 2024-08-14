package com.kh.spring09.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {
	
	//수동으로 객체를 등록하기 위해서는 @Bean 을 사용한다.
	@Bean
//	public JavaMailSenderImpl sender() {//하위 클래스 (참치김밥)
	public JavaMailSender sender() {//상위 클래스 (김밥, 업캐스팅)
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		sender.setHost("smtp.gmail.com");//이용할 업체의 호스트 정보
		sender.setPort(587);//이용할 업체의 포트번호
		sender.setUsername("meansuck9998oo");//계정
		sender.setPassword("iheslxrwmyeshyea");//앱 비밀번호
		
		Properties props = new Properties(); //자바에서 제공하는 문자열 Key=Value 저장소
		props.setProperty("mail.smtp.auth", "true"); //인증 후 이용하도록 설정
		props.setProperty("mail.smtp.debug", "true"); //디버깅 허용 설정
		props.setProperty("mail.smtp.starttls.enable", "true"); //TLS 사용 설정
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS 버전 설정
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); //신뢰할 수 있는 주소로 등록
		sender.setJavaMailProperties(props);
		
		return sender;
	}
	
}
