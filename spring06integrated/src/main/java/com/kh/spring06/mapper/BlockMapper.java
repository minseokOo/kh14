package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.dto.BlockDto;

@Service
public class BlockMapper implements RowMapper<BlockDto> {

	@Override
	public BlockDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BlockDto blockDto = new BlockDto();
		blockDto.setBlockNo(rs.getInt("block_no"));
		blockDto.setBlockType(rs.getString("block_type"));
		blockDto.setBlockMemo(rs.getString("block_memo"));
		blockDto.setBlockTime(rs.getDate("block_time"));
		blockDto.setBlockTarget(rs.getString("block_target"));
		
		return blockDto;
	}
	
}
