package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test02패딩암호화 {

	@Test
	public void test(){
		
		//패딩 암호화
		// - 특정 글자 (ex : a)를 모든 글자의 뒤에 추가하여 원본을 알아볼 수 없게 만드는 방식의 암호화
		
		//(Q)
		//원본 : hello java
		String origin = "hello java";
		
		//암호화 : haealalaoa ajaaavaaa
		StringBuffer buffer = new StringBuffer();
		String securityWord = "a";
		for(int i=0; i<origin.length(); i++) {
			char ch = origin.charAt(i);
			buffer.append(ch);
			buffer.append(securityWord);
//			System.out.println(ch);
		}
		String encrypt = buffer.toString();
		System.out.println("암호화 : " + encrypt);
		//복호화 : hello java
		buffer = new StringBuffer();
		for(int i=0; i<encrypt.length(); i+=2) {
			char ch = encrypt.charAt(i);
			buffer.append(ch);
		}
		String decrypt = buffer.toString();
		System.out.println("복호화 : " + decrypt);
	}
}
