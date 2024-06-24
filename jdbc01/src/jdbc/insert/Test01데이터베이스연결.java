package jdbc.insert;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01데이터베이스연결 {
	public static void main(String[] args) {
		//Spring JDBC
		// - 스프링 프레임 워크에서 제공하는 JDBC 관련 라이브러리
		// - 등록 절차가 선행 되어야한다.
		
		// 연결 도구 - DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// Java 에서 사용할 데이터베이스 종류를 인식 시키기 위한 정보
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		// 데이터베이스의 위치정보 (연결유형@DBMS위치)
		// - localhost는 자기 자신을 의미하는 주소 (IP계의 this)
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh14");
		dataSource.setPassword("kh14");
		
		System.out.println("연결 완료!");
		
		
		
	}
}
