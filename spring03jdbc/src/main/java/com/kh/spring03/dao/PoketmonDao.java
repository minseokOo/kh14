package com.kh.spring03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring03.dto.PoketmonDto;
import com.kh.spring03.mapper.PoketmonMapper;

@Repository //저장관리도구를 등록하는 방법 (영속성 제어도구)
public class PoketmonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PoketmonMapper mapper;

	//입력
	public void insert(PoketmonDto dto) {
		String sql = "insert into poketmon("
				+ "poketmon_no, poketmon_name, poketmon_type"
				+ ") "
				+ "values(poketmon_seq.nextval, ?, ?)";
		Object[] data = {dto.getPoketmonName(), dto.getPoketmonType()};
		jdbcTemplate.update(sql, data);
	}
	
	//수정
	public boolean update(PoketmonDto dto) {
		String sql = "update poketmon "
				+ "set poketmon_name = ?, poketmon_type = ? "
				+ "where poketmon_no = ?";
		Object[] data = {
				dto.getPoketmonName(), dto.getPoketmonType(),
				dto.getPoketmonNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//삭제
	public boolean delete(int poketmonNo) {
		String sql = "delete poketmon where poketmon_no = ?";
		Object[] data = {poketmonNo};
		return jdbcTemplate.update(sql,data) > 0;
	}
}
