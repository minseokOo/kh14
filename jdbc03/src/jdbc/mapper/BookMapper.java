package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.BookDto;

public class BookMapper implements RowMapper<BookDto> {

	@Override
	public BookDto mapRow(ResultSet rs, int idx) throws SQLException {
		BookDto dto = new BookDto();
		dto.setBookId(rs.getInt("book_id"));
		dto.setBookTitle(rs.getString("book_title"));
		dto.setBookAuthor(rs.getString("book_author"));
		dto.setBookPublication(rs.getString("book_publication_date"));
		dto.setBookPrice(rs.getInt("book_price"));
		dto.setBookPublisher(rs.getString("book_publisher"));
		dto.setBookPage(rs.getInt("book_page_count"));
		dto.setBookGenre(rs.getString("book_genre"));
		
		return dto;
	}

}
