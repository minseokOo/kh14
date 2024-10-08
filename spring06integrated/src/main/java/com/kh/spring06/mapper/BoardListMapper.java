package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.dto.BoardDto;

@Service
public class BoardListMapper implements RowMapper<BoardDto> {

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		boardDto.setBoardWtime(rs.getDate("board_wtime"));
		boardDto.setBoardUtime(rs.getDate("board_utime"));
		boardDto.setBoardViews(rs.getInt("board_views"));
		boardDto.setBoardLikes(rs.getInt("board_likes"));
		boardDto.setBoardReplies(rs.getInt("board_replies"));
		boardDto.setBoardGroup(rs.getInt("board_group"));
		boardDto.setBoardTarget(rs.getObject("board_target", Integer.class));
		boardDto.setBoardDepth(rs.getInt("board_depth"));
		return boardDto;
	}


}
