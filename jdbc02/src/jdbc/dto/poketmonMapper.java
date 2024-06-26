package jdbc.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class poketmonMapper implements RowMapper<PoketmonDto> {

	@Override
	public PoketmonDto mapRow(ResultSet rs, int arg1) throws SQLException {
		PoketmonDto dto = new PoketmonDto();
		dto.setPoketmonNo(rs.getInt("poketmon_no"));
		dto.setPoketmonName(rs.getString("poketmon_name"));
		dto.setPoketmonType(rs.getString("poketmon_type"));
		return dto;
	}

}
