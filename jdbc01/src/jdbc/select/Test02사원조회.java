package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.EmpDto;
import jdbc.util.EmpMapper;
import jdbc.util.JdbcHelper;

public class Test02사원조회 {
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from emp";
		
		EmpMapper mapper = new EmpMapper();
		
		List<EmpDto> list = jdbcTemplate.query(sql,  mapper);
		
		System.out.println("개수 : " + list.size());
		
		for(EmpDto dto : list) {
			System.out.println(dto.getEmpNo());
			System.out.println(dto.getEmpName());
			System.out.println(dto.getEmpDept());
			System.out.println(dto.getEmpDate());
			System.out.println(dto.getEmpRank());
			System.out.println(dto.getEmpSal());
		}
	}
}
