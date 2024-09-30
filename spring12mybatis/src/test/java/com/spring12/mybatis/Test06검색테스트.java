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


//Lombok에게 이 클래스에 필요한 로깅 도구를 만들어달라고 부탁
@Slf4j //slf4j는 하위 로깅 도구들(ex: log4j, logback)등을 스프링에서 쓰도록 만든 어댑터 라이브
@SpringBootTest
public class Test06검색테스트 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		List<MemberDto> list = sqlSession.selectList("member.listSearch");
		
		//column & keyword 검색
//		Map params = new HashMap();
//		params.put("column", "member_id");
//		params.put("keyword", "admin");
//		List<MemberDto> list = sqlSession.selectList("member.listSearch", params);
		
//		System.out.println(list.size());
//		log.debug("결과 수 : " + list.size());
		log.debug("결과 수 : {}", list.size());
		log.info("결과 수 :" + list.size());
		for(MemberDto memberDto:list) {
			//System.out.println(memberDto);
			log.debug(memberDto.toString());
			log.info(memberDto.toString());
		}
	}
}
