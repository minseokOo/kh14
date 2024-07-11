package com.kh.spring06.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BlockDto;
import com.kh.spring06.mapper.BlockMapper;

@Repository
public class BlockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BlockMapper blockMapper;
	
	//차단 등록
	public void insertBlock(BlockDto blockDto) {
		String sql = "insert into block("
				+ "block_no, block_type, "
				+ "block_memo, block_target) "
				+ "values(block_seq.nextval, '차단', ?, ?)";
		Object[] data = {blockDto.getBlockMemo(), blockDto.getBlockTarget()};
		jdbcTemplate.update(sql,data);
	}
	
	//해제 등록
	public void cancel(BlockDto blockDto) {
		String sql = "insert into block("
				+ "block_no, block_type, "
				+ "block_memo, block_target) "
				+ "values(block_seq.nextval, '해제', ?, ?)";
		Object[] data = {blockDto.getBlockMemo(), blockDto.getBlockTarget()};
		jdbcTemplate.update(sql, data);
	}
	
}
