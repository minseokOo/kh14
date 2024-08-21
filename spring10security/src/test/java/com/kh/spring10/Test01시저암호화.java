package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01시저암호화 {

	@Test
	public void test() {
		//암호화(Encryption) - 대상을 어떤 방식을 이용해 변조하는 것
		//복호화(Decryption) - 변조된 대상을 원래대로 되돌리는 것
		//단방향 암호화 - 암호화만 가능하고 복호화는 불가능한 암호화 방식
		//양방향 암호화 - 암호화와 복호화가 모두 가능한 방식
		
		//1. 암호화를 위한 문자열 준비
		String origin = "hello java";
		
		//2. 암호화(시저 암호화, caesar)
		StringBuffer buffer = new StringBuffer();
		int offset = 3;
		for(int i=0; i<origin.length(); i++) {
			char ch = origin.charAt(i); //현재 위치의 글자를 추출
			ch += offset; //offset만큼 이동
			buffer.append(ch);//buffer에 추가
			
		}
		
		//3. 결과 출력
		String result = buffer.toString();
		System.out.println("원본 : " + origin);
		System.out.println("결과 : " + result);
		
		//4. 복호화
		buffer = new StringBuffer();//버퍼 신규생성
		for(int i=0; i<result.length(); i++) {
			char ch = result.charAt(i);//한 글자를 추출하여
			ch -= offset; //offset만큼 되돌리고
			buffer.append(ch);//버퍼에 추가
		}
		
		//5. 결과 출력
		String result2 = buffer.toString();
		System.out.println("복원 : " + result2);
	}
	
}
