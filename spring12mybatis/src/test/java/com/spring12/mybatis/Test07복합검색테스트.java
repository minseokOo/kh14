package com.spring12.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.mybatis.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test07복합검색테스트 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		 Map<String, Object> params = new HashMap();
		 params.put("memberId", "user");
//		 params.put("memberNickname", "테스트");
//		 params.put("memberBirth", "1990-01-01");
		 params.put("memberPhone", "example");
		 
		 List<MemberDto> list = sqlSession.selectList("member.complexSearch", params);
		 	
		 for(MemberDto dto : list) {
			 
			 log.debug(dto.toString());
		 }
	}
}
