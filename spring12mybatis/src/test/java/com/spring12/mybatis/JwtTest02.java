package com.spring12.mybatis;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JwtTest02 {

	@Test
	public void test() {
		// 생성된 토큰을 해석
		
		//토큰 문자열 준비(원본, Test01에서 생성)
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJtZW1iZXJJZCI6InVzZXIwMSIsIm1lbWJlckxldmVsIjoi7J2867CY7ZqM7JuQIiwiZXhwIjoxNzI3ODUwNzMwLCJpc3MiOiJLSOygleuztOq1kOycoeybkCIsImlhdCI6MTcyNzg1MDEzMH0.unHmXkKG6lmwu5FE63X62Y0UVMslECw0KUZNF1-RNJg";
		
		//해석을 위한 열쇠 준비
		String keyStr = "sdafoifqwijoqfkvclkxvnadalkadsnafsadd";
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		
		//토큰 해석 - claim 정보를 읽는 것이 목적
		Claims claims = (Claims) Jwts.parser()//해석 도구
				.verifyWith(key)//증명을 위한 열쇠를 설정하고
				.requireIssuer("KH정보교육원")//발행자 정보까지 일치하는지 확인
				.build()//위의 정보를 바탕으로 도구를 만드세요
				.parse(token)//토큰을 해석하고
				.getPayload(); //정보 가져오기
		
		//정보 출력
		log.info("memberId = {}", claims.get("memberId"));
		log.info("memberLevel = {}", claims.get("memberLevel"));
		
	}
}
