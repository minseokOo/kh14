package com.spring12.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.mybatis.dto.PoketmonDto;

@SpringBootTest
public class Test04수정테스트 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void edit() {
		
		PoketmonDto poketmonDto = new PoketmonDto();
		
		int no = 9;
		poketmonDto = sqlSession.selectOne("poketmon.find", no);
		System.out.println(poketmonDto);
		poketmonDto.setPoketmonNo(no);
		poketmonDto.setPoketmonName("피카츄");
		poketmonDto.setPoketmonType("전기");
		
		
		int result = sqlSession.update("poketmon.edit", poketmonDto);
		
		if(result > 0) {
			System.out.println("성공");
			System.out.println("수정 결과 : "+poketmonDto);
		}
		else {
			System.out.println("실패");
		}
		
		
	}
}
