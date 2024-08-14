package com.kh.spring09;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class Test03단문메세지발송 {

	@Test
	public void test() {
		//[1] 전송 도구 생성
		//[2] 이용할 서드파티 서비스(Gmail) 정보 입력
		//[3] 메세지 생성
		//[4] 전송
		
		//[1]
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		//[2]
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
		
		//[3] - 수신자(to), 제목(subject), 내용(text), 참조(cc), 숨은참조(bcc)
		Random r = new Random();
		int cert = r.nextInt(1000000);
		DecimalFormat fmt = new DecimalFormat("000000");
		String value = fmt.format(cert);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("minseok916@gmail.com");
		message.setSubject("[KH정보교육원] 인증번호 안내");
		message.setText("인증번호는 " + value +"입니다.");
		message.setCc();
		
		//[4]
		sender.send(message);
	}
}
