package com.kh.spring03.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring03.dto.PoketmonDto;

// 등록하여 사용하는 클래스(1개만 필요)
@Service // 컨트롤러가 필요할 때마다 이용하는 부하(서비스)
public class PoketmonMapper implements RowMapper<PoketmonDto>{

	@Override
	public PoketmonDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		PoketmonDto dto = new PoketmonDto();
		dto.setPoketmonNo(rs.getInt("poketmon_no"));
		dto.setPoketmonName(rs.getString("poketmon_name"));
		dto.setPoketmonType(rs.getString("poketmon_type"));
		
		return dto;
	}

	
}
