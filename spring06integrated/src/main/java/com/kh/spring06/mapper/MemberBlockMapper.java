package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.vo.MemberBlockVO;

@Service
public class MemberBlockMapper implements RowMapper<MemberBlockVO> {

	@Override
	public MemberBlockVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberBlockVO memberBlockVO = new MemberBlockVO();
		memberBlockVO.setMemberId(rs.getString("member_id"));
		memberBlockVO.setMemberPw(rs.getString("member_pw"));
		memberBlockVO.setMemberNickname(rs.getString("member_nickname"));
		memberBlockVO.setMemberBirth(rs.getString("member_birth"));
		memberBlockVO.setMemberContact(rs.getString("member_contact"));
		memberBlockVO.setMemberEmail(rs.getString("member_email"));
		memberBlockVO.setMemberLevel(rs.getString("member_level"));
		memberBlockVO.setMemberPoint(rs.getInt("member_point"));
		memberBlockVO.setMemberPost(rs.getString("member_post"));
		memberBlockVO.setMemberAddress1(rs.getString("member_address1"));
		memberBlockVO.setMemberAddress2(rs.getString("member_address2"));
		memberBlockVO.setMemberJoin(rs.getDate("member_join"));
		memberBlockVO.setMemberLogin(rs.getDate("member_login"));
		
		memberBlockVO.setBlockNo(rs.getInt("block_no"));
		memberBlockVO.setBlockType(rs.getString("block_type"));
		memberBlockVO.setBlockMemo(rs.getString("block_memo"));
		memberBlockVO.setBlockTime(rs.getDate("block_time"));
		memberBlockVO.setBlockTarget(rs.getString("block_target"));
		return memberBlockVO;
	}

}
