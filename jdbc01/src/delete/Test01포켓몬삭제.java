package delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test01포켓몬삭제 {
	public static void main(String[] args) {
		
		//준비
		int poketmonNo = 3;
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete poketmon where poketmon_no = ?";
		Object[] data = {poketmonNo};
		int result = jdbcTemplate.update(sql, data);
		
		//출력
		if(result > 0) {
		System.out.println("포켓몬 삭제 완료");
		}
		else {
			System.out.println("대상이 존재하지 않습니다.");
		}
	}
}
