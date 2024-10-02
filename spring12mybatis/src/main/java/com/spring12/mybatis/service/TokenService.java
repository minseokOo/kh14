package com.spring12.mybatis.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring12.mybatis.configuration.TokenProperties;
import com.spring12.mybatis.vo.MemberClaimVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	
	@Autowired
	private TokenProperties tokenProperties;
	
	//토큰 생성 메소드
	public String create(MemberClaimVO vo) {
		SecretKey key = Keys.hmacShaKeyFor(tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		c.add(Calendar.MINUTE, tokenProperties.getExpire());
		Date limit = c.getTime();
		//토큰
		return Jwts.builder()
						.signWith(key)
						.expiration(limit)
						.issuer(tokenProperties.getIssuer())
						.issuedAt(now)
						.claim("memberId", vo.getMemberId())
						.claim("memberLevel", vo.getMemberLevel())
				.compact();
		
	}
	
	//토큰 검증 메소드
	public MemberClaimVO check(String token) {
		//키 생성
		SecretKey key = Keys.hmacShaKeyFor(tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		//토큰 해석
		Claims claims = (Claims) Jwts.parser()
				.verifyWith(key)
				.requireIssuer(tokenProperties.getIssuer())
				.build()
				.parse(token)
				.getPayload();
		//결과 생성 및 반환
		MemberClaimVO vo = new MemberClaimVO();
		vo.setMemberId((String) claims.get("memberId"));
		vo.setMemberLevel((String) claims.get("memberLevel"));
		return vo;
	}
}
