package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.PoketmonDto;
import com.kh.spring06.mapper.PoketmonMapper;
import com.kh.spring06.mapper.StatusMapper;
import com.kh.spring06.vo.StatusVO;

@Repository //저장관리도구를 등록하는 방법 (영속성 제어도구)
public class PoketmonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PoketmonMapper poketmonMapper;
	@Autowired
	private StatusMapper statusMapper;

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
			return jdbcTemplate.query(sql, poketmonMapper);
		}
		
		//검색
		public List<PoketmonDto> selectList(String column, String keyword) {
			String sql = "select * from poketmon "
							+ "where instr("+column+", ?) > 0 "
							+ "order by "+column+" asc, poketmon_no asc";
			Object[] data = {keyword};
			return jdbcTemplate.query(sql, poketmonMapper, data);
		}

		//상세
		public PoketmonDto selectOne(int poketmonNo) {
			String sql = "select * from poketmon where poketmon_no = ?";
			Object[] data = {poketmonNo};
			List<PoketmonDto> list = jdbcTemplate.query(sql, poketmonMapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
		
		//포켓몬 통계 현황 조회 기능
		public List<StatusVO> status() {
			String sql = "select poketmon_type title, count(*) cnt from poketmon "
							+ "group by poketmon_type "
							+ "order by cnt desc, poketmon_type asc";
			return jdbcTemplate.query(sql, statusMapper);
			
		}
		
		// 시퀀스 생성 및 등록 메소드
		public int sequence() {
			String sql = "select poketmon_seq.nextval from dual";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		public void insertWithSequence(PoketmonDto poketmonDto) {
			String sql = "insert into poketmon("
					+ "poketmon_no, poketmon_name, poketmon_type"
					+ ") values(?, ?, ?)";
			Object[] data = {
					poketmonDto.getPoketmonNo(),
					poketmonDto.getPoketmonName(),
					poketmonDto.getPoketmonType()
			};
			jdbcTemplate.update(sql, data);
			
		}
		
		//연결기능
		public void connect(int poketmonNo, int attachmentNo) {
			String sql = "insert into poketmon_image(poketmon, attachment) "
					+ "values(?, ?)";
			Object[] data = {poketmonNo, attachmentNo};
			jdbcTemplate.update(sql, data);
		}
		
		//이미지 번호 찾기 기능
		public Integer findImage(int poketmonNo) {
			String sql = "select attachment from poketmon_image where poketmon=?";
			Object[] data = {poketmonNo};
			return jdbcTemplate.queryForObject(sql, Integer.class, data);
		}
		
		
}
