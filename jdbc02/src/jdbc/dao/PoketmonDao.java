package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PoketmonDto;
import jdbc.mapper.poketmonMapper;
import jdbc.util.JdbcHelper;

// DAO
// - Data Access Object
// - DB 처리 대행 클래스
public class PoketmonDao {

	private JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
	
	private poketmonMapper mapper = new poketmonMapper();
	
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
	
//	조회 메소드
	public List<PoketmonDto> selectList(){
		String sql = "select * from poketmon order by poketmon_no asc";
		//Object[] data = {};
		return jdbcTemplate.query(sql, mapper);
	}
	
//	검색 메소드
//	select * from piketmon 
//	where instr(항목, 키워드) > 0
//	order by 항목 asc, poketmon_no asc
	public List<PoketmonDto> selectList(String column, String keyword){
		String sql = "select * from poketmon "
				+ "where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, poketmon_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, mapper, data);
	}
	
//	상세 메소드
//	- 상세조회를 위한 Mapper는 따로 존재한다(ResultSetExtractor)
//	- 따로 만들지 않고 목록/검색용 Mapper 를 활용한다.
	public PoketmonDto selectOne(int poketmonNo) {
		String sql = "select * from poketmon where poketmon_no = ?";
		Object[] data = {poketmonNo};
		List<PoketmonDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0); //비어있으면 ? null : 맨 앞에 거;
	}

}
