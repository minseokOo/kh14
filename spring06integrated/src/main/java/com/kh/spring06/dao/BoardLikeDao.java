package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BoardDto;
import com.kh.spring06.mapper.BoardListMapper;

@Repository
public class BoardLikeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardListMapper boardListMapper;
	
	//[1] 아이디와 글 번호를 가지고 기록 유무를 조회하는 기능
	public boolean check(String memberId, int boardNo) {
		if(memberId == null) return false;
		
		String sql = " select count(*) from board_like "
				+ "where member_id=? and board_no=?";
		Object[] data = {memberId, boardNo};
		int count = jdbcTemplate.queryForObject(sql, int.class, data);
		return count > 0;
	}
	//[2] 글번호에 대한 카운트를 세는 기능
	public int count(int boardNo) {
		String sql = "select count(*) from board_like where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
	//[3] 좋아요 등록 기능
	public void insert(String memberId, int boardNo) {
		String sql = "insert into board_like values(?, ?)";
		Object[] data = {memberId, boardNo};
		jdbcTemplate.update(sql, data);
	}
	//[4] 좋아요 삭제 기능
	public boolean delete(String memberId, int boardNo) {
		String sql = "delete board_like where member_id=? and board_no = ?";
		Object[] data = {memberId, boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	//좋아요 누른 글 조회
	public  List<BoardDto> selectList(String memberId, int boardNo){
		String sql = "SELECT board_no FROM board_like WHERE member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.query(sql,  boardListMapper, data);
	}
	
}
