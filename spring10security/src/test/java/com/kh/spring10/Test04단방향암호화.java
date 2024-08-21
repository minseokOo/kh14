package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test04단방향암호화 {

	@Test
	public void test() {
		//단방향 암호화는 절대로 복호화가 불가능해야 한다.
		
		//1. 데이터 준비
		int origin = 12345;
		
		//2. 암호화
		int calc = (origin + 9999) * 12321 + 55555;
		int encrypt = calc % 1000000;
		
		//3. 출력
		System.out.println("암호화 : " + encrypt);
	}
}
