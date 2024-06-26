package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PoketmonDto;
import jdbc.util.JdbcHelper;

// DAO
// - Data Access Object
// - DB 처리 대행 클래스
public class PoketmonDao {

	// 등록 메소드
	//public void insert(String poketmonName, String poketmonType) {
	public void insert(PoketmonDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "insert into poketmon("
				+ "poketmon_no, poketmon_name, poketmon_type"
				+ ") values(poketmon_seq.nextval, ?, ?)";
		Object[] data = {dto.getPoketmonName(), dto.getPoketmonType()};
		jdbcTemplate.update(sql,data);
	}
	//수정 메소드
	public boolean update(PoketmonDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update poketmon "
				+ "set poketmon_name=?, poketmon_type=? "
				+ "where poketmon_no=?";
		Object[] data = {
				dto.getPoketmonName(), dto.getPoketmonType(),
				dto.getPoketmonNo()
		};
//		int result = jdbcTemplate.update(sql, data);
//		return result > 0;
		return jdbcTemplate.update(sql, data) > 0;
	}
//	삭제 메소드
	public boolean delete(int poketmonNo) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete poketmon where poketmon_no=?";
		Object[] data = {poketmonNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
}
