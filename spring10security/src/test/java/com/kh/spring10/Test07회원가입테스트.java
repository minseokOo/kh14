package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class Test07회원가입테스트 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Test
	public void test() {
		//데이터 준비
		String memberId = "testuser1";
		String memberPw = "Testuser1!";
		String memberNickname = "테스트유저1";
		
		//암호화
		memberPw = encoder.encode(memberPw);
		
		//JDBC
		String sql = "insert into secure_member("
				+ "member_id, member_pw, member_nickname"
				+ ") values(?, ?, ?)";
		Object[] data = {memberId, memberPw, memberNickname};
		jdbcTemplate.update(sql,data);
		
		
	}
}
