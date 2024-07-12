package com.kh.spring06.dao;

import java.util.List;

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
	
	//차단 목록
	public List<BlockDto> blockList(String blockTarget){
		String sql = "select * from block where block_target = ? order by block_no desc";
		Object[] data = {blockTarget};
		return jdbcTemplate.query(sql, blockMapper, data);
	}
	
	//차단 상태 확인
	
	
	//스페셜 기능
	// - 주어진 아이디의 마지막 block 정보를 상세 조회하는 기능 (서브쿼리 사용)
	public BlockDto selectLastOne(String blockTarget) {
		String sql = "select * from block where block_no = ("
				+ "select max(block_no) from block where block_target = ?)";
		Object[] data = {blockTarget};
		List<BlockDto> list = jdbcTemplate.query(sql, blockMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
