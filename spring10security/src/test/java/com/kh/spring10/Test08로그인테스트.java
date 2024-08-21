package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dao.SecureMemberDao;
import com.kh.spring10.dto.SecureMemberDto;

@SpringBootTest
public class Test08로그인테스트 {

	@Autowired
	private SecureMemberDao secureMemberDao;
	
	@Test
	public void test() {
		for(int i=2; i < 50; i++) {
		String memberId = "testuser"+i;
		String memberPw = "Testuser2!";
		
		SecureMemberDto secureMemberDto = secureMemberDao.selectOneWithPassword(memberId, memberPw);
		
		System.out.println(secureMemberDto);
		}
	}
}
