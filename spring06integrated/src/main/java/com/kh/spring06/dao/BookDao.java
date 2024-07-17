package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BookDto;
import com.kh.spring06.mapper.BookMapper;
import com.kh.spring06.vo.PageVO;

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
	
	public List<BookDto> selectListByPaging(PageVO pageVO){
		if(pageVO.isSearch()) {
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
					+ "select * from book where instr(#1, ?) > 0 "
					+ "order by #1 asc, book_id asc"
					+ ")TMP"
					+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] data = {pageVO.getColumn(), pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, mapper, data);
		}
		else {
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
					+ "select * from book order by book_id asc"
					+ ")TMP"
					+ ") where rn between ? and ?";
			Object[] data = {pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, mapper, data);
		}
	}
	public int countByPaging(PageVO pageVO) {
		if(pageVO.isSearch()) {//검색
			String sql = "select count(*) from book where instr(#1, ?) > 0";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] data = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else {//목록
			String sql = "select count(*) from book";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
}