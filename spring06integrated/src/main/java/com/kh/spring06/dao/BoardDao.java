package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BoardDto;
import com.kh.spring06.mapper.BoardListMapper;
import com.kh.spring06.vo.PageVO;
import com.kh.spring06.mapper.BoardDetailMapper;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardDetailMapper boardDetailMapper;
	
	@Autowired
	private BoardListMapper boardListMapper;
	
	//글 목록
	public List<BoardDto> selectList(){
		String sql = "select "
				+ "board_no, board_title, board_writer, board_wtime, "
				+ "board_utime, board_views, board_likes, board_replies  "
				+ "from board order by board_no desc";
		return jdbcTemplate.query(sql, boardListMapper);
	}
	
	//글 검색
		public List<BoardDto> selectList(String column, String keyword) {
		    String sql = "select "
		    		+ "board_no, board_title, board_writer, board_wtime, "
					+ "board_utime, board_views, board_likes, board_replies  "
		    		+ " from board " 
		                + "where instr(" + column + ", ?) > 0 " 
		                + "order by " + column + " desc, board_no desc";
		    Object[] data = {keyword};
		    return jdbcTemplate.query(sql, boardListMapper, data);
		}
		
		//상세 메소드
		public BoardDto selectOne(int boardNo) {
			String sql = "select * from board where board_no = ?";
			Object[] data = {boardNo};
			List<BoardDto> list = jdbcTemplate.query(sql, boardDetailMapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
	
	
	//글 등록
	public int sequence() {
		String sql = "SELECT board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
		
	public void write(BoardDto boardDto) {
		String sql = "insert into board (BOARD_NO, BOARD_TITLE, "
							+ "BOARD_CONTENT, BOARD_WRITER) "
							+ "values(?, ?, ?, ?)";
		Object[] data = {
				boardDto.getBoardNo(), boardDto.getBoardTitle(), 
				boardDto.getBoardContent(), boardDto.getBoardWriter(),
		};
		jdbcTemplate.update(sql, data);
	}
	
	//글 수정
	public boolean update(BoardDto boardDto) {
		String sql = "update board set "
				+ "board_title=?, board_content=?, "
				+ "board_utime=sysdate where board_no = ?";
		Object[] data = {
				boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//글 삭제
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no=?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
}	
	//조회수 증가
	public boolean updateBoardViews(int boardNo) {
		String sql = "update board "
				+ "set board_views=board_views+1 "
				+ "where board_no=?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//페이징이 적용된 목록
	public List<BoardDto> selectListByPaging(int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size - 1);
		String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select "
										+ "board_no, board_title, board_writer, board_wtime, "
										+ "board_utime, board_views, board_likes, board_replies, "
										+ "board_group, board_target, board_depth  "
									+ "from board order by board_no desc"
								+ ")TMP"
							+ ") where rn between ? and ?";
		Object[] data = {beginRow, endRow};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	//페이징이 적용된 검색
	public List<BoardDto> selectListByPaging(
		String column, String keyword, int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size - 1);
		String sql = "select * from ("
				+ "select rownum rn, TMP.* from ("
				+ "select "
					+ "board_no, board_title, board_writer, board_wtime, "
					+ "board_utime, board_views, board_likes, board_replies,  "
					+ "board_group, board_target, board_depth  "
		    		+ " from board " 
		                + "where instr(" + column + ", ?) > 0 " 
		                + "order by " + column + " desc, board_no desc"
			+ ")TMP"
		+ ") where rn between ? and ?";
		Object[] data = {keyword, beginRow, endRow};
		return jdbcTemplate.query(sql, boardListMapper, data);
		
	}
	
	//페이징의 마지막 블록 번호를 위해 게시글 수를 구하는 메소드
	public int countByPaging() {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public int countByPaging(String column, String keyword) {
		String sql = "select count(*) from board where instr(#1, ?) > 0";
		sql = sql.replace("#1", column);
		Object[] data = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
	
	//페이징 객체를 이용한 목록 및 검색 메소드
	public List<BoardDto> selectListByPaging(PageVO pageVO) {
		if(pageVO.isSearch()) {//검색이라면
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select "
										+ "board_no, board_title, board_writer, board_wtime, "
										+ "board_utime, board_views, board_likes, board_replies, "
										+ "board_group, board_target, board_depth "		
									+ "from board "
									+ "where instr(#1, ?) > 0 "
									+ "connect by prior board_no = board_target "
									+ "start with board_target is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
						+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] data = {
					pageVO.getKeyword(), 
					pageVO.getBeginRow(), 
					pageVO.getEndRow() 
			};
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
		else {//목록이라면
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select "
										+ "board_no, board_title, board_writer, board_wtime, "
										+ "board_utime, board_views, board_likes, board_replies, "
										+ "board_group, board_target, board_depth "
									+ "from board "
									+  "connect by prior board_no = board_target "
									+ "start with board_target is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
						+ ") where rn between ? and ?";
			Object[] data = {pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
	}

	public int countByPaging(PageVO pageVO) {
		if(pageVO.isSearch()) {//검색카운트
			String sql = "select count(*) from board where instr(#1, ?) > 0";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] data = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else {//목록카운트
			String sql = "select count(*) from board";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
}
