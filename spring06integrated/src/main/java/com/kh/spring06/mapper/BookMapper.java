package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.dto.BookDto;

@Service
public class BookMapper implements RowMapper<BookDto>{
	@Override
	public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookDto dto = new BookDto();
		dto.setBookId(rs.getInt("book_id"));
		dto.setBookTitle(rs.getString("book_title"));
		dto.setBookAuthor(rs.getString("book_author"));
		dto.setBookPublicationDate(rs.getString("book_publication_date"));
		dto.setBookPrice(rs.getInt("book_price"));
		dto.setBookPublisher(rs.getString("book_publisher"));
		dto.setBookPageCount(rs.getInt("book_page_count"));
		dto.setBookGenre(rs.getString("book_genre"));
		return dto;
	}

}
