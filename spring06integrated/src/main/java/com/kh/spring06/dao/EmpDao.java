package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.EmpDto;
import com.kh.spring06.mapper.EmpMapper;
import com.kh.spring06.mapper.StatusMapper;
import com.kh.spring06.vo.StatusVO;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private StatusMapper statusMapper;
	
	public void insert(EmpDto dto) {
		String sql = "insert into emp("
				+ "emp_no, emp_name, emp_dept, emp_date, emp_rank, emp_sal"
				+ ") "
				+ "values(emp_seq.nextval, ?, ?, ?, ?, ?)";
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
        return jdbcTemplate.query(sql, empMapper);
    }
    public List<EmpDto> selectList(String column, String keyword) {
        String sql = "select * from emp "
                        + "where instr(#1, ?) > 0 "
                        + "order by #1 asc, emp_no asc";
        sql = sql.replace("#1", column);
        Object[] data = {keyword};
        return jdbcTemplate.query(sql, empMapper, data);
    }
	//상세 메소드
	public EmpDto selectOne(int empNo) {
		String sql = "select * from emp where emp_no = ?";
		Object[] data = {empNo};
		List<EmpDto> list = jdbcTemplate.query(sql, empMapper, data);
		return list.isEmpty() ? null : list.get(0);
//		EmpExtractor extractor = new EmpExtractor();
//		return jdbcTemplate.query(sql, extractor, data);
	}
	public List<StatusVO> statusByEmpDept(){
		String sql = "select emp_dept title, count(*) cnt from emp group by emp_dept "
				+ "order by cnt desc, title asc";
		return jdbcTemplate.query(sql, statusMapper);
	}
	public List<StatusVO> statusByEmpRank(){
		String sql = "select emp_rank title, count(*) cnt from emp group by emp_rank "
				+ "order by cnt desc, title asc";
		return jdbcTemplate.query(sql, statusMapper);
	}
	
	// 시퀀스 생성 및 등록 메소드
	public int sequence() {
		String sql = "select emp_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insertWithSequence(EmpDto empDto) {
		String sql = "insert into emp("
				+ "emp_no, emp_name, emp_dept, emp_date, emp_rank, emp_sal"
				+ ") values(?, ?, ?, ?, ?, ?)";
		Object[] data = {
				empDto.getEmpNo(), empDto.getEmpName(), empDto.getEmpDept(), 
				empDto.getEmpDate(), empDto.getEmpRank(), empDto.getEmpSal()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//연결 기능
	public void connect(int empNo, int attachmentNo) {
		String sql = "insert into emp_photo(emp, attachment) "
				+ "values(?, ?)";
		Object[] data = {empNo, attachmentNo};
		jdbcTemplate.update(sql, data);
}
	//이미지 번호 찾기 기능
	public Integer findImage(int empNo) {
		String sql = "select attachment from emp_photo where emp=?";
		Object[] data = {empNo};
		return jdbcTemplate.queryForObject(sql, Integer.class, data);
	}
}
