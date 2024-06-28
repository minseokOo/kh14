package com.kh.spring03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poketmon")
public class PoketmonController {

	// (중요) 스프링에서 만들었거나 등록된 도구들을 쓰고싶다면 "주세요" 해봐
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/insert")
	public String insert(
			@RequestParam String poketmonName,
			@RequestParam String poketmonType) {
		
		//등록을 하려면
		String sql = "insert into poketmon("
				+ "poketmon_no, poketmon_name, poketmon_type"
				+ ") "
				+ "values(poketmon_seq.nextval, ?, ?)";
		Object[] data = {poketmonName, poketmonType};
		jdbcTemplate.update(sql, data);
		
		return "포켓몬 등록 완료";
	}
	
	
}
