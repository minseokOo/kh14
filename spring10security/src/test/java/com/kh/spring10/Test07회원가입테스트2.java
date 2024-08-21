package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dao.SecureMemberDao;
import com.kh.spring10.dto.SecureMemberDto;

@SpringBootTest
public class Test07회원가입테스트2 {

	@Autowired
	private SecureMemberDao secureMemberDao;
	
	@Test
	public void test() {
		//데이터 준비
		SecureMemberDto secureMemberDto = new SecureMemberDto();
		
		for(int i=3; i<50; i++) {
		secureMemberDto.setMemberId("testuser" + i);
		secureMemberDto.setMemberPw("Testuser2!");
		secureMemberDto.setMemberNick("테스트유저" + i);
		
		
		//JDBC
		secureMemberDao.insert(secureMemberDto);
		}
	}
}
