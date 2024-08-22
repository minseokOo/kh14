package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.service.PaddingEncryptService;

@SpringBootTest
public class Test02패딩암호화2 {

	@Autowired
	private PaddingEncryptService encService;
	
	@Test
	public void test(){
		
		//패딩 암호화
		// - 특정 글자 (ex : a)를 모든 글자의 뒤에 추가하여 원본을 알아볼 수 없게 만드는 방식의 암호화
		
		//(Q)
		//원본 : hello java
		String origin = "안녕하세요 반갑습니다";
		
		//암호화 : haealalaoa ajaaavaaa
		String encrypt = encService.encode(origin,"a");
		System.out.println("암호화 : " + encrypt);
		//복호화 : hello java
		String decrypt = encService.decode(encrypt);
		
		System.out.println("복호화 : " + decrypt);
	}
}
