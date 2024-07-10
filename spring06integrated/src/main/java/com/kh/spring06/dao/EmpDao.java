package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.EmpDto;
import com.kh.spring06.mapper.EmpMapper;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmpMapper mapper;
	
	public void insert(EmpDto dto) {
		String sql = "insert into emp("
				+ "emp_no, emp_name, emp_dept, emp_date, emp_rank, emp_sal"
				+ ") "
				+ "values(emp_no_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {dto.getEmpName(), dto.getEmpDept(), dto.getEmpDate(), dto.getEmpRank(), dto.getEmpSal()};
		jdbcTemplate.update(sql, data);
	}
	public boolean edit(EmpDto dto) {
		String sql = "update emp "
				+ "set emp_name = ?, emp_dept = ?, emp_date = ?, emp_rank = ?, emp_sal = ? "
				+ "where emp_no = ?";
		Object[] data = {dto.getEmpName(), dto.getEmpDept(), dto.getEmpDate(), dto.getEmpRank(), dto.getEmpSal(), dto.getEmpNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	public boolean remove(int empNo) {
		String sql = "delete emp where emp_no = ?";
		Object[] data = {empNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public List<EmpDto> selectList() {
        String sql = "select * from emp order by emp_no asc";
        return jdbcTemplate.query(sql, mapper);
    }
    public List<EmpDto> selectList(String column, String keyword) {
        String sql = "select * from emp "
                        + "where instr(#1, ?) > 0 "
                        + "order by #1 asc, emp_no asc";
        sql = sql.replace("#1", column);
        Object[] data = {keyword};
        return jdbcTemplate.query(sql, mapper, data);
    }
	//상세 메소드
	public EmpDto selectOne(int empNo) {
		String sql = "select * from emp where emp_no = ?";
		Object[] data = {empNo};
		List<EmpDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
//		EmpExtractor extractor = new EmpExtractor();
//		return jdbcTemplate.query(sql, extractor, data);
	}
	
}
