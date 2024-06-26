package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.EmpDto;
import jdbc.mapper.EmpMapper;
import jdbc.util.JdbcHelper;

public class EmpDao {
	
	private JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
	private EmpMapper mapper = new EmpMapper();
	
	public void insert(EmpDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "insert into emp "
				+ "("
				+ "emp_no, emp_name, emp_dept, emp_date, emp_rank, emp_sal"
				+ ") "
				+ "values(emp_no_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {dto.getEmpName(), 
								dto.getEmpDept(), 
								dto.getEmpDate(), 
								dto.getEmpRank(), 
								dto.getEmpSal()};
		jdbcTemplate.update(sql,data);
	}
	public boolean update(EmpDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update emp "
				+ "set emp_name=?, emp_dept=?, emp_date=?, emp_rank=?, emp_sal=? "
				+ "where emp_no=? ";
		Object[] data = {
				dto.getEmpName(), dto.getEmpDept(), dto.getEmpDate(), dto.getEmpRank(), dto.getEmpSal(), dto.getEmpNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
		
		public boolean delete(int empNo) {
			JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
			String sql = "delete emp where emp_no=?";
			Object[] data = {empNo};
			return jdbcTemplate.update(sql, data) > 0;
		
	}
		public List<EmpDto> selectList(){
			String sql = "select * from emp order by emp_no asc";
			return jdbcTemplate.query(sql, mapper);
		}
	
}
