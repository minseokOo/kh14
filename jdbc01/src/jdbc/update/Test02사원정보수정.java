package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test02사원정보수정 {
	public static void main(String[] args) {
		
		//데이터
				int empNo = 3;
				String empName = "어쩌구";
				String empDept = "개발팀";
				String empDate = "2022-01-01";
				String empRank = "과장";
				int empSal = 6000000;
				
				//처리
				JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
				String sql = "update emp "
						+ "set emp_name = ?, emp_dept= ?, emp_date =?,"
						+ "emp_rank=?, emp_sal=? "
						+ "where emp_no = ?";
				Object[] data = {
						empName, empDept, empDate, 
						empRank, empSal, empNo
				};
				int result = jdbcTemplate.update(sql, data);
				
				//출력
				if(result > 0) {
					System.out.println("사원 정보 변경 완료");
				}
				else {
					System.out.println("존재하지 않는 사원 번호");
				}
				
				
	}
}
