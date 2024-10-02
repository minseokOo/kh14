package com.spring12.mybatis;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JwtTest01 {

	@Test
	public void test() {
		
		//JWT 토큰 생성
		// 1. 서명, 인증을 위한 키(Secret Key) 생성
		// - 암호화 방식은 HMAC을 사용
		// - 메세지의 무결성, 인증을 동시에 처리하기 위하여 키를 사용하는 암호화 방식
		// - 명칭은 HMAC-SHA로 시작
		
		//충분히 길게 작성
		String keyStr = "sdafoifqwijoqfkvclkxvnadalkadsnafsadd";
		
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		
		//만료시간을 계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		c.add(Calendar.MINUTE, 10);
		Date limit = c.getTime();
		
		//토큰 생성
		String token = Jwts.builder()
					//정보 설정
				.signWith(key)//서명에 사용할 키 정보
				//정보 설정
//				.claim("key", value)
				.claim("memberId", "user01")
				.claim("memberLevel", "일반회원")
				//시간 설정(java.util.Date)
				.expiration(limit)
				//발급자 정보(issuer)
				.issuer("KH정보교육원")
				.issuedAt(now)
				.compact();
		
		//결과 확인
		log.info("token = {}", token);
		
		
	}
}
