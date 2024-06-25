package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.BookDto;
import jdbc.util.BookMapper;
import jdbc.util.JdbcHelper;

public class Test03도서조회 {
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from book";
		
		BookMapper mapper = new BookMapper();
		List<BookDto> list = jdbcTemplate.query(sql, mapper);
		
		System.out.println(list.size());
		
		for(BookDto dto:list) {
			System.out.println(dto.getBookId());
			System.out.println(dto.getTitle());
			System.out.println(dto.getAuthor());
			System.out.println(dto.getPublicationDate());
			System.out.println(dto.getPrice());
			System.out.println(dto.getPublisher());
			System.out.println(dto.getPage());
			System.out.println(dto.getGenre());
			
		}
	}
}
