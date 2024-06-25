package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test01포켓몬수정 {
	public static void main(String[] args) {
		
		//데이터 준비
		int poketmonNo = 9999;
		String poketmonName = "어쩌구";
		String poketmonType = "저쩌구";
		
		//JDBC
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update poketmon set poketmon_name=?, poketmon_type=?"
				+ "where poketmon_no=?";
		Object[] data = {poketmonName,poketmonType,poketmonNo};
		int count = jdbcTemplate.update(sql, data);
		System.out.println("count = " + count);
		
		//출력
		if(count > 0) {
		System.out.println("정보변경 완료");
		}
		else {
		System.out.println("존재하지 않는 번호");
		}
		
	}
}
