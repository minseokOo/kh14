package com.spring12.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.mybatis.dto.PoketmonDto;

@SpringBootTest
public class Test02등록테스트 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//데이터 준비
		PoketmonDto poketmonDto = new PoketmonDto();
		poketmonDto.setPoketmonName("뮤츠");
		poketmonDto.setPoketmonType("무속성");
		
		//DB처리
		sqlSession.insert("poketmon.save", poketmonDto);
	}
}
