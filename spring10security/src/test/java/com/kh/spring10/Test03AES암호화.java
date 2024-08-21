package com.kh.spring10;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;

@SpringBootTest
public class Test03AES암호화 {

//	AesBytesEncryptor encryptor = new AesBytesEncryptor(암호키, 솔트);
	AesBytesEncryptor encryptor = new AesBytesEncryptor("khacademy", "123456");
	
	@Test
	public void test() {
		//1. 암호화를 위한 문자열 준비
		String origin = "hello java";
		
		//2. 암호화
		byte[] encryptBytes = encryptor.encrypt(origin.getBytes());
		
		//3. 출력
		System.out.println("암호화 : " + Arrays.toString(encryptBytes));
		
		//4. 복호화
		byte[] decryptBytes = encryptor.decrypt(encryptBytes);
		String decrypt = new String(decryptBytes);
		
		//5. 출력
		System.out.println("복호화 : " + decrypt);
		
	}
}
