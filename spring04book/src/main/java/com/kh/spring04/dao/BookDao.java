package com.kh.spring04.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring04.dto.BookDto;
import com.kh.spring04.mapper.BookMapper;

@Repository
public class BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BookMapper mapper;

	
	//CRUD 메소드
	public void insert(BookDto dto) {
		String sql = "insert into book("
							+ "book_id, book_title, book_author, book_publication_date, "
							+ "book_price, book_publisher, book_page_count, book_genre"
						+ ") "
						+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
			dto.getBookTitle(), dto.getBookAuthor(), dto.getBookPublicationDate(),
			dto.getBookPrice(), dto.getBookPublisher(), dto.getBookPageCount(),
			dto.getBookGenre()
		};
		jdbcTemplate.update(sql, data);
	}
	public List<BookDto> selectList() {
		String sql = "select * from book order by book_id asc";
		return jdbcTemplate.query(sql, mapper);
	}
	public List<BookDto> selectList(String column, String keyword) {
		String sql = "select * from book where instr(#1, ?) > 0 "
					+ "order by #1 asc, book_id asc";
		sql = sql.replace("#1", column);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, mapper, data);
	}
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id = ?";
		Object[] data = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	public boolean update(BookDto dto) {
		String sql = "update book set "
						+ "book_title=?, book_author=?, book_publication_date=?, "
						+ "book_price=?, book_publisher=?, book_page_count=?, "
						+ "book_genre=? "
						+ "where book_id = ?";
		Object[] data = {
			dto.getBookTitle(), dto.getBookAuthor(), dto.getBookPublicationDate(),
			dto.getBookPrice(), dto.getBookPublisher(), dto.getBookPageCount(),
			dto.getBookGenre(), dto.getBookId()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	public boolean delete(int bookId) {
		String sql = "delete book where book_id=?";
		Object[] data = {bookId};
		return jdbcTemplate.update(sql, data) > 0;
	}
}