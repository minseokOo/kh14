package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BoardDto;
import com.kh.spring06.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	//글 목록
	public List<BoardDto> selectList(){
		String sql = "select * from board order by board_no desc";
		return jdbcTemplate.query(sql, boardMapper);
	}
	
	//글 검색
		public List<BoardDto> selectList(String column, String keyword) {
		    String sql = "select * from board " 
		                + "where instr(" + column + ", ?) > 0 " 
		                + "order by " + column + " desc, board_no desc";
		    Object[] data = {keyword};
		    return jdbcTemplate.query(sql, boardMapper, data);
		}
		
		//상세 메소드
		public BoardDto selectOne(int boardNo) {
			String sql = "select * from board where board_no = ?";
			Object[] data = {boardNo};
			List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
	
	
	//글 등록
	public void write(BoardDto boardDto) {
		String sql = "insert into board (BOARD_NO, BOARD_TITLE, "
							+ "BOARD_CONTENT, BOARD_WRITER, board_wtime, board_utime, "
							+ "board_views, board_likes, board_replies) "
							+ "values(board_seq.nextval, ?, ?, ?, sysdate, sysdate, ?, ?, ?)";
		Object[] data = {
				boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriter(),
				boardDto.getBoardViews(), 
				boardDto.getBoardLikes(), boardDto.getBoardReplies()
		};
		jdbcTemplate.update(sql, data);
	}
}
