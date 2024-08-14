package com.kh.spring09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class Test02DB연결 {
	//@SpringBootTest로 등록했으므로 @Autowired 사용 가능 (src/main/java도 가능)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		//포켓몬 등록
		String sql = "insert into poketmon(poketmon_no, poketmon_name, poketmon_type"
				+ ") values(poketmon_seq.nextval, ?, ?)";
		Object[] data = {"아무거나", "불꽃"};
		jdbcTemplate.update(sql, data);
	}
}
