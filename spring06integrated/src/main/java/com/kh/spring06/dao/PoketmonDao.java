package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.PoketmonDto;
import com.kh.spring06.mapper.PoketmonMapper;

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
	
	//조회
		public List<PoketmonDto> selectList() {
			String sql = "select * from poketmon order by poketmon_no asc";
			return jdbcTemplate.query(sql, mapper);
		}
		
		//검색
		public List<PoketmonDto> selectList(String column, String keyword) {
			String sql = "select * from poketmon "
							+ "where instr("+column+", ?) > 0 "
							+ "order by "+column+" asc, poketmon_no asc";
			Object[] data = {keyword};
			return jdbcTemplate.query(sql, mapper, data);
		}

		//상세
		public PoketmonDto selectOne(int poketmonNo) {
			String sql = "select * from poketmon where poketmon_no = ?";
			Object[] data = {poketmonNo};
			List<PoketmonDto> list = jdbcTemplate.query(sql, mapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
}
