package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.vo.StatusVO;

@Service
public class StatusMapper implements RowMapper<StatusVO> {

	@Override
	public StatusVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StatusVO statusVO = new StatusVO();
		statusVO.setTitle(rs.getString("title"));
		statusVO.setCnt(rs.getInt("cnt"));
		return statusVO;
	}
	
}
