package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04사원등록 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh14");
		dataSource.setPassword("kh14");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		//int emp_no = sc.nextInt();
		String empName = sc.nextLine();
		String empDept = sc.nextLine();
		String empDate = sc.nextLine();
		String empRank = sc.nextLine();
		int emp_sal = sc.nextInt();
		
		String sql = "insert into emp(emp_no, emp_name, emp_dept, emp_date, emp_rank, emp_sal"
				+ "values(emp_no_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] input = {empName, empDept, empDate, empRank, emp_sal};
		jdbcTemplate.update(sql, input);
		System.out.println("입력완료");
	}
	
}
