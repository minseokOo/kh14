package com.spring12.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.mybatis.service.TokenService;
import com.spring12.mybatis.vo.MemberClaimVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JwtTest03 {

	@Autowired
	private TokenService tokenService;
	
	@Test
	public void test() {
		//생성
		MemberClaimVO vo = new MemberClaimVO();
		vo.setMemberId("user01");
		vo.setMemberLevel("일반회원");
		
		String token = tokenService.create(vo);
		log.info("token = {}", token);
		
		//검증
		log.info("decrypt = {}", tokenService.check(token));
	}
}
