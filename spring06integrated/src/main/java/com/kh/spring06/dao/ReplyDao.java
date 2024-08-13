package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.ReplyDto;
import com.kh.spring06.mapper.ReplyMapper;

@Repository
public class ReplyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	public int sequence() {
		String sql = "select reply_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(ReplyDto replyDto) {
		String sql = "insert into reply(reply_no, reply_writer, reply_content, reply_origin) "
				+ "values(?, ?, ?, ?)";
		Object[] data = {
				replyDto.getReplyNo(), replyDto.getReplyWriter(), replyDto.getReplyContent(), replyDto.getReplyOrigin()
		};
		jdbcTemplate.update(sql, data);
	}
	public List<ReplyDto> selectList(int replyOrigin){
		String sql = "select * from reply where reply_origin = ? "
				+ "order by reply_no asc";
		Object[] data = {replyOrigin};
		return jdbcTemplate.query(sql, replyMapper, data);
	}
	public List<ReplyDto> selectList(int replyOrigin, int page, int size){
		int endRow = page * 10;
		int beginRow = endRow - (size-1);
		String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select * from reply "
						+ "where reply_origin=? "
						+ "order by reply_no desc"
					+ ")TMP"
				+ ") "
				+ "where rn between ? and ? "
				+ "order by reply_no asc";
		Object[] data = {replyOrigin, beginRow, endRow};
		return jdbcTemplate.query(sql, replyMapper, data);
		
	}
	public boolean delete(int replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] data = {replyNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public ReplyDto selectOne(int replyNo) {
		String sql = "select * from reply where reply_no = ?";
		Object[] data = {replyNo};
		List<ReplyDto> list = jdbcTemplate.query(sql, replyMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	public boolean update(ReplyDto replyDto) {
		String sql = "update reply "
				+ "set reply_content=?, reply_utime=sysdate "
				+ "where reply_no=?";
		Object[] data = {replyDto.getReplyContent(), replyDto.getReplyNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	public int count(int replyOrigin) {
		String sql = "select count(*) from reply where reply_origin = ?";
		Object[] data = {replyOrigin};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
}
