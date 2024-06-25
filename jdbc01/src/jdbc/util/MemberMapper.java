package jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<MemberDto> {

	@Override
	public MemberDto mapRow(ResultSet rs, int idx) throws SQLException {
		
		MemberDto dto = new MemberDto();
		dto.setId(rs.getString("member_id"));
		dto.setPw(rs.getString("member_pw"));
		dto.setNickname(rs.getString("member_nickname"));
		dto.setBirth(rs.getString("member_birth"));
		dto.setContact(rs.getString("member_contact"));
		dto.setEmail(rs.getString("member_email"));
		dto.setLevel(rs.getString("member_level"));
		dto.setPoint(rs.getInt("member_point"));
		dto.setPost(rs.getString("member_post"));
		dto.setAddress1(rs.getString("member_address1"));
		dto.setAddress2(rs.getString("member_address2"));
		dto.setJoin(rs.getString("member_join"));
		dto.setLogin(rs.getString("member_login"));
		
		
		return null;
	}

}
