package com.kh.spring10;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test05SHA암호화 {

	@Test
	public void test() {
		//Spring Security에는 SHA 관련 암호화가 사라졌다.
		//apache commons codec이라는 라이브러리를 사용하여 테스트
		
//		DigestUtils utils = new DigestUtils("SHA3-224");//56byte
//		DigestUtils utils = new DigestUtils("SHA3-256");//64byte
//		DigestUtils utils = new DigestUtils("SHA3-384");//96byte
		DigestUtils utils = new DigestUtils("SHA3-512");//128byte
		
		String origin = "hello java";
		
		String encrypt = utils.digestAsHex(origin);
		
		System.out.println("암호화 : " + encrypt);
		
		System.out.println("글자수 : " + encrypt.length());
		
	}
}
