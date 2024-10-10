package com.spring12.restapi.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring12.restapi.configuration.TokenProperties;
import com.spring12.restapi.dao.MemberTokenDao;
import com.spring12.restapi.dto.MemberTokenDto;
import com.spring12.restapi.vo.MemberClaimVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	
	public static final String BEARER_PREFIX = "Bearer ";
	
	@Autowired
	private TokenProperties tokenProperties;
	
	@Autowired
	private MemberTokenDao memberTokenDao;
	
	//토큰 생성 메소드
	public String createAccessToken(MemberClaimVO vo) {
		//키 생성
		SecretKey key = Keys.hmacShaKeyFor(
				tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		//만료시간 계산
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
	
	
	//리프레시 토큰 생성
	//- 긴 시간동안 사용할 수 있도록 처리
	//- DB에 이 토큰의 정보를 저장해서 나중에 비교가 가능하도록 처리
	public String createRefreshToken(MemberClaimVO vo) {
		//키 생성
		SecretKey key = Keys.hmacShaKeyFor(
				tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		//만료시간 계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		c.add(Calendar.MONTH, 1);
		Date limit = c.getTime();
		//토큰
		String token = Jwts.builder()
					.signWith(key)
					.expiration(limit)
					.issuer(tokenProperties.getIssuer())
					.issuedAt(now)
					.claim("memberId", vo.getMemberId())
					.claim("memberLevel", vo.getMemberLevel())
				.compact();
		
		//DB 저장
		MemberTokenDto memberTokenDto = new MemberTokenDto();
		memberTokenDto.setTokenTarget(vo.getMemberId());
		memberTokenDto.setTokenValue(token);
		memberTokenDao.insert(memberTokenDto);
		
		return token;
	}
	
	//토큰 검증 메소드
	public MemberClaimVO check(String token) {
		//키 생성
		SecretKey key = Keys.hmacShaKeyFor(
				tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
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

	//Bearer 토큰인지 검사하는 메소드
	public boolean isBearerToken(String token) {
		return token != null && token.startsWith(BEARER_PREFIX);
	}
	
	//Bearer 를 제거하는 메소드
	public String removeBearer(String token) {
		//return token.substring(7);
		return token.substring(BEARER_PREFIX.length());
	}
	
	@Scheduled(cron = "0 0 0 * * *")
	public void clearToken() {
		memberTokenDao.clear();
	}
}