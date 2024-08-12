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
	
	public boolean delete(int replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] data = {replyNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
}
