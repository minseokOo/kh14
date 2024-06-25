package delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test02사원삭제 {
	public static void main(String[] args) {
		
		int empNo = 3;
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete emp where emp_no=?";
		Object[] data = {empNo};
		
		int result = jdbcTemplate.update(sql, data);
		
		if(result > 0) {
			System.out.println("데이터가 삭제 되었습니다.");
		}
		else {
			System.out.println("대상이 존재하지 않습니다.");
		}
	}
}
