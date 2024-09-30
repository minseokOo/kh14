package com.spring12.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test03삭제테스트 {

	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Test
	public void test() {
		int poketmonNo = 8;
		int result = sqlSession.delete("poketmon.remove", poketmonNo);
		if(result > 0) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
	}
}
