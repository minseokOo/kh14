package com.kh.spring03.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring03.dto.EmpDto;

@Service
public class EmpMapper implements RowMapper<EmpDto> {

	@Override
	public EmpDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmpDto dto = new EmpDto();
		dto.setEmpNo(rs.getInt("emp_no"));
		dto.setEmpName(rs.getString("emp_name"));
		dto.setEmpDept(rs.getString("emp_dept"));
		dto.setEmpDate(rs.getString("emp_date"));
		dto.setEmpRank(rs.getString("emp_rank"));
		dto.setEmpSal(rs.getInt("emp_sal"));
		return dto;
	}

}
