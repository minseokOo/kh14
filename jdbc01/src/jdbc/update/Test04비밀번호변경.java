package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test04비밀번호변경 {
	public static void main(String[] args) {
		
		String id = "ads341";
		String pw = "1Q2w3e4r!";
		String newPw = "1Q2w3E4r!";
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update member "
				+ "set member_pw=? "
				+ "where member_id = ? and member_pw = ?";
		
		Object[] data = {newPw, id, pw};
		int result = jdbcTemplate.update(sql,data);
		
		if(result > 0) {
		System.out.println("비밀번호 변경 완료");
		}
		else {
		System.out.println("존재하지 않는 회원 정보");
		}
		
		
		
	}
}
