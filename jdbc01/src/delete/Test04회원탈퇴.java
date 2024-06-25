package delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test04회원탈퇴 {
	public static void main(String[] args) {
		
		String memberId = "ads341";
		String memberPw = "1Q2w3E4r!";
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete member where member_id=? and member_pw=?";
		Object[] data = {memberId, memberPw};
		int result = jdbcTemplate.update(sql, data);
		
		if(result > 0 ) {
			System.out.println("삭제 되었습니다.");
		}
		else {
			System.out.println("대상이 존재하지 않습니다.");
		}
	}
}
