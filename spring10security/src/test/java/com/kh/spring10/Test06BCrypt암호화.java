package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class Test06BCrypt암호화 {

	@Test
	public void test() {
		//BCrypt는 평문(암호화 전 글자)에 시간을 더하여 암호화하는 방식
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		for(int i=0; i<5; i++) {
			
		String origin = "hello java";
		String encrypt = encoder.encode(origin);
		int count = i+1;
		System.out.println("암호화 " + count + " : " + encrypt);
//		System.out.println("글자수 : " + encrypt.length());

		//이미 암호화된 값이 새로운 입력값과 같은지 비교할 수 있는가? yes
		//-> input을 암호화 해서 비교하는게 아니라 비교 명령을 사용해야 한다.
		String input = "hello java";
		boolean isValid = encoder.matches(input, encrypt);
		System.out.println("isValid = " + isValid);
		System.out.println();
		}
	}
}
