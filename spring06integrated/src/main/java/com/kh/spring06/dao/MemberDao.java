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
import com.kh.spring06.vo.PageVO;
import com.kh.spring06.vo.StatusVO;
@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;
	
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
	
	//회원 닉네임 검색
	public MemberDto selectOneByMemberNickname(String memberNickname) {
		String sql = "select * from member where member_nickname = ?";
		Object[] data = {memberNickname};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	
	//최종 로그인 시각 갱신(U)
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member set member_login=sysdate "
						+ "where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//비밀번호 변경(U)
	public boolean updateMemberPw(String memberId, String memberPw) {
		String sql = "update member set member_pw=? where member_id=?";
		Object[] data = {memberPw, memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//회원 개인의 정보 변경(U)
	public boolean updateMember(MemberDto memberDto) {
		String sql = "update member set "
							+ "member_nickname=?, member_email=?,"
							+ "member_birth=?,member_contact=?,"
							+ "member_post=?,member_address1=?,member_address2=? "
						+ "where member_id=?";
		Object[] data = {
			memberDto.getMemberNickname(), memberDto.getMemberEmail(),
			memberDto.getMemberBirth(), memberDto.getMemberContact(),
			memberDto.getMemberPost(), memberDto.getMemberAddress1(),
			memberDto.getMemberAddress2(), memberDto.getMemberId()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//회원 탈퇴(D)
	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//회원 목록(R)
	public List<MemberDto> selectList() {
		String sql = "select * from member order by member_id";
		return jdbcTemplate.query(sql, memberMapper);
	}
	//회원 검색(R)
	public List<MemberDto> selectList(String column, String keyword) {
		String sql = "select * from member where instr(#1, ?) > 0 "
						+ "order by #1 asc, member_id asc";
		sql = sql.replace("#1", column);//정적할당
		Object[] data = {keyword};//동적할당
		return jdbcTemplate.query(sql, memberMapper, data);
	}

	//회원 수정(U) - 관리자용
	public boolean updateMemberByAdmin(MemberDto memberDto) {
		String sql = "update member set "
						+ "member_nickname=?, member_email=?,"
						+ "member_contact=?, member_birth=?,"
						+ "member_level=?, member_point=?,"
						+ "member_post=?,"
						+ "member_address1=?, member_address2=? "
						+ "where member_id = ?";
		Object[] data = {
			memberDto.getMemberNickname(), memberDto.getMemberEmail(),
			memberDto.getMemberContact(), memberDto.getMemberBirth(),
			memberDto.getMemberLevel(), memberDto.getMemberPoint(),
			memberDto.getMemberPost(), memberDto.getMemberAddress1(),
			memberDto.getMemberAddress2(), memberDto.getMemberId()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Autowired
	private StatusMapper statusMapper;
	
	public List<StatusVO> statusByMemberLevel() {
		String sql = "select member_level title, count(*) cnt from member "
						+ "group by member_level "
						+ "order by cnt desc, title asc";
		return jdbcTemplate.query(sql, statusMapper);
	}
	
	//회원 목록에 차단을 합쳐서 조회
	public List<MemberBlockVO> selectListWithBlock(String column, String keyword) {
		String sql = "select "
							+ "M.*, B.block_no, B.block_time, B.block_memo, "
							+ "B.block_target, nvl(B.block_type, '해제') block_type "
						+ "from member M "
							+ "left outer join block_latest B "
							+ "on M.member_id=B.block_target "
							+ "where instr(#1, ?) > 0 "
							+ "order by #1 asc, M.member_id asc";
		sql = sql.replace("#1", column);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, memberBlockMapper, data);
	}

	//페이징 관련 메소드
	public List<MemberBlockVO> selectListWithBlockByPaging(PageVO pageVO) {
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
									+ "select "
										+ "M.*, B.block_no, B.block_time, B.block_memo, "
										+ "B.block_target, nvl(B.block_type, '해제') block_type "
									+ "from member M "
										+ "left outer join block_latest B "
										+ "on M.member_id=B.block_target "
										+ "where instr(#1, ?) > 0 "
										+ "order by #1 asc, M.member_id asc"
							+ ")TMP"
						+ ") where rn between ? and ?";
		sql = sql.replace("#1", pageVO.getColumn());
		Object[] data = {
			pageVO.getKeyword(), pageVO.getBeginRow(),
			pageVO.getEndRow()
		};
		return jdbcTemplate.query(sql, memberBlockMapper, data);
	}
	public int countByPaging(PageVO pageVO) {
		String sql = "select count(*) from member where instr(#1, ?) > 0";
		sql = sql.replace("#1", pageVO.getColumn());
		Object[] data = {pageVO.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}

	//회원 이미지 연결
	public void connect(String memberId, int attachmentNo) {
		String sql = "insert into member_image(member, attachment) values(?, ?)";
		Object[] data = {memberId, attachmentNo};
		jdbcTemplate.update(sql, data);
	}

	public int findImage(String memberId) {
		String sql = "select attachment from member_image where member=?";
		Object[] data = {memberId};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
}
