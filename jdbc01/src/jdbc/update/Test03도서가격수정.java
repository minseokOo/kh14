package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test03도서가격수정 {
	public static void main(String[] args) {
		//준비
				int bookId = 3;
				int bookPrice = 5000;
				
				//처리
				JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
				String sql = "update book set book_price = ? where book_id = ?";
				Object[] data = {bookPrice, bookId};
				int result = jdbcTemplate.update(sql, data);
				
				//출력
				if(result > 0) {
					System.out.print("가격 변경 완료");
				}
				else {
					System.out.println("존재하지 않는 도서 번호");
				}
	
	}
}