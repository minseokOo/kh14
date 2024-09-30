package com.spring12.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.mybatis.dto.PoketmonDto;

@SpringBootTest
public class Test05상세테스트 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		int poketmonNo = 9;
		
		PoketmonDto poketmonDto = 
				sqlSession.selectOne("poketmon.find", poketmonNo);
		
		System.out.println("poketmonDto = " + poketmonDto);
	}
}
