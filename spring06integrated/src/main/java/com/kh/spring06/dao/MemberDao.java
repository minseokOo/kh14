package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.MemberDto;
import com.kh.spring06.mapper.MemberBlockMapper;
import com.kh.spring06.mapper.MemberMapper;
import com.kh.spring06.mapper.StatusMapper;
import com.kh.spring06.vo.MemberBlockVO;
import com.kh.spring06.vo.StatusVO;
@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private StatusMapper statusMapper;
	
	@Autowired
	private MemberBlockMapper memberBlockMapper;
	
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
	//관리자 전용 정보변경 구현
	public boolean updateMemberAdmin(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_nickname = ?, member_email = ?, member_birth = ?, "
				+ "member_level = ?, member_point = ?, "
				+ "member_contact = ?, member_post = ?, "
				+ "member_address1 = ?, member_address2 = ? "
				+ "where member_id = ?";
		Object[] data = {memberDto.getMemberNickname(), memberDto.getMemberEmail(), memberDto.getMemberBirth(), 
				memberDto.getMemberLevel(), memberDto.getMemberPoint(),
				memberDto.getMemberContact(), memberDto.getMemberPost(),
				memberDto.getMemberAddress1(), memberDto.getMemberAddress2(),
				memberDto.getMemberId()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	//회원 탈퇴 구현
	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//회원 목록
	public List<MemberDto> selectList() {
        String sql = "select * from member order by member_id asc";
        return jdbcTemplate.query(sql, memberMapper);
    }
	//회원 검색
	public List<MemberDto> selectList(String column, String keyword) {
	    String sql = "select * from member " +
	                 "where instr(" + column + ", ?) > 0 " +
	                 "order by " + column + " asc, member_id asc";
	    Object[] data = {keyword};
	    return jdbcTemplate.query(sql, memberMapper, data);
	}
	public List<StatusVO> statusByMemberLevel(){
		String sql = "select member_level title, count(*) cnt from member group by member_level "
				+ "order by cnt desc, title asc";
		return jdbcTemplate.query(sql, statusMapper);
	}
	
	//회원 목록에 차단을 합쳐서 조회
	public List<MemberBlockVO> selectListWithBlock(String column, String keyword){
		String sql="select "
                + "M.*, B.block_no, B.block_time, B.block_memo,"
                + "B.block_target, nvl(B.block_type, '해제') block_type "
                + "from member M left outer join block_latest B "
                + "on M.member_id=B.block_target "
                + "where instr("+column+",?)>0 "
                        + "order by "+column+" asc, member_id asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, memberBlockMapper, data);
	}
	
}
