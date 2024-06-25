package jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//조회 결과(resultSet)를 자바 DTO로 이동시키는 방법을 정의하는 클래스
//상속을 받아서 구현(RowMapper)
public class PoketmonMapper implements RowMapper<PoketmonDto>{

	@Override
	public PoketmonDto mapRow(ResultSet rs, int idx) throws SQLException {
		//rs에 있는 데이터를 DTO로 이동시켜서 반환
		PoketmonDto dto = new PoketmonDto();
		dto.setPoketmonNo(rs.getInt("poketmon_no"));
		dto.setPoketmonName(rs.getString("poketmon_name"));
		dto.setPoketmonType(rs.getString("poketmon_type"));
		return dto;
	}

}
