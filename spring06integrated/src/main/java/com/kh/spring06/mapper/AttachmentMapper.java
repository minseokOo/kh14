package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.dto.AttachmentDto;

@Service
public class AttachmentMapper implements RowMapper<AttachmentDto> {

	@Override
	public AttachmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		AttachmentDto attachmentDto = new AttachmentDto();
		attachmentDto.setAttachmentNo(rs.getInt("attachment_no"));
		attachmentDto.setAttachmentName(rs.getString("attachment_name"));
		attachmentDto.setAttachmentType(rs.getString("attachment_type"));
		attachmentDto.setAttachmentSize(rs.getLong("attachment_size"));
		return attachmentDto;
	}
	
}
