package jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<BookDto> {

	@Override
	public BookDto mapRow(ResultSet rs, int idx) throws SQLException {
		BookDto dto = new BookDto();
		dto.setBookId(rs.getInt("book_id"));
		dto.setTitle(rs.getString("book_title"));
		dto.setAuthor(rs.getString("book_author"));
		dto.setPublicationDate(rs.getString("book_publication_date"));
		dto.setPrice(rs.getInt("book_price"));
		dto.setPublisher(rs.getString("book_publisher"));
		dto.setPage(rs.getInt("book_page_count"));
		dto.setGenre(rs.getString("book_genre"));
		return dto;
	}

}
