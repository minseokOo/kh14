package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02등록테스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("포켓몬 이름 : ");
		String poketmonName = sc.nextLine();
		System.out.print("포켓몬 속성 : ");
		String poketmonType = sc.nextLine();
		sc.close(); 

		//JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh14");
		dataSource.setPassword("kh14");

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		String sql = "insert into poketmon(poketmon_no, poketmon_name, poketmon_type) "
				+ "values(poketmon_seq.nextval, ?, ?)";
		Object[] data = {poketmonName, poketmonType};
		jdbcTemplate.update(sql, data);
		System.out.println("등록 완료");

	}
}
