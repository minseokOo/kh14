package com.spring12.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.mybatis.dto.PoketmonDto;

@SpringBootTest
public class Test01마이바티스테스트 {

	//myBatis 구문을 호출하기 위한 도구
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		List<PoketmonDto> list = sqlSession.selectList("poketmon.list");
		for(PoketmonDto poketmonDto : list) {
			System.out.println(poketmonDto);
		}
	}
}
