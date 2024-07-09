package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.MemberDto;
import com.kh.spring06.mapper.MemberMapper;
@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;
	
	//필요한 데이터베이스 기능들을 메소드로 구현
	
	//회원 등록(C)
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
							+ "member_id, member_pw, member_nickname, "
							+ "member_birth, member_contact, member_email, "
							+ "member_post, member_address1, member_address2"
						+ ") "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
			memberDto.getMemberId(), memberDto.getMemberPw(),
			memberDto.getMemberNickname(), memberDto.getMemberBirth(),
			memberDto.getMemberContact(), memberDto.getMemberEmail(),
			memberDto.getMemberPost(), memberDto.getMemberAddress1(),
			memberDto.getMemberAddress2()
		};
		jdbcTemplate.update(sql, data);
	}

	//회원 상세(R)
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ?";
		Object[] data = {memberId};
		List<MemberDto> list = 	jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//회원 비밀번호 변경
	public boolean updateMemberPw(String memberId, String memberPw) {
		String sql = "update member "
				+ "set member_pw = ?"
				+ "where member_id = ?";
		Object[] data = {memberPw, memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//최종 로그인 시각 갱신(U)
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member set member_login=sysdate "
				+ "where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//개인정보 변경 구현
	public boolean updateMember(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_nickname = ?, member_email = ?, member_birth = ?, "
				+ "member_contact = ?, member_post = ?, "
				+ "member_address1 = ?, member_address2 = ? "
				+ "where member_id = ?";
		Object[] data = {memberDto.getMemberNickname(), memberDto.getMemberEmail(), memberDto.getMemberBirth(),
				memberDto.getMemberContact(), memberDto.getMemberPost(),
				memberDto.getMemberAddress1(), memberDto.getMemberAddress2(),
				memberDto.getMemberId()};
		return jdbcTemplate.update(sql, data) > 0;
				
	}
	//회원 탈퇴 구현
	public boolean deleteMember(MemberDto memberDto) {
		String sql = "delete member where member_id = ?";
		Object[] data = {memberDto.getMemberId()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public List<MemberDto> selectList() {
        String sql = "select * from member order by member_id asc";
        return jdbcTemplate.query(sql, memberMapper);
    }
	public List<MemberDto> selectList(String column, String keyword) {
	    String sql = "select * from member " +
	                 "where instr(" + column + ", ?) > 0 " +
	                 "order by " + column + " asc, member_id asc";
	    Object[] data = {keyword};
	    return jdbcTemplate.query(sql, memberMapper, data);
	}
	
}
