package jdbc.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcHelper {
	private JdbcHelper() {}
	
	public static JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh14");
		dataSource.setPassword("kh14");
		
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		return jdbcTemplate;
	}
}