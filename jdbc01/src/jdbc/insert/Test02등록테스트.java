package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02등록테스트 {
	public static void main(String[] args) {
		//연결
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh14");
		dataSource.setPassword("kh14");
		
		//구문전송 + 실행도구
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "insert into poketmon(poketmon_no, poketmon_name, poketmon_type) "
				+ "values(poketmon_seq.nextval, '자바몬', '전기')";
		jdbcTemplate.update(sql);
		System.out.println("등록 완료!");
	}
}
