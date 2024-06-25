package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05도서등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh14");
		dataSource.setPassword("kh14");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		System.out.println("제목");
		String title = sc.nextLine();
		System.out.println("작가");
		String author = sc.nextLine();
		System.out.println("배급일");
		String publicationDate = sc.nextLine();
		System.out.println("가격");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("배급사");
		String publisher = sc.nextLine();
		System.out.println("페이지수");
		int page = sc.nextInt();
		sc.nextLine();
		System.out.println("장르");
		String genre = sc.nextLine();
		
		sc.close();
		
		String sql = "insert into book(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) "
				+ "values(book_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {title, author, publicationDate, price, publisher, page, genre};
		jdbcTemplate.update(sql, data);
		System.out.println("입력완료");
	}
}
