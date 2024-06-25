package delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test03도서삭제 {
	public static void main(String[] args) {
		
		int bookId = 12;
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete book where book_id=?";
		Object[] data = {bookId};
		int result = jdbcTemplate.update(sql, data);
		if(result > 0) {
			System.out.println("데이터가 삭제되었습니다.");
		}
		else {
			System.out.println("대상이 존재하지 않습니다.");
		}
		
	}
}
