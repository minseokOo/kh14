package jdbc.book;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test02수정 {
	public static void main(String[] args) {
		
		BookDto dto = new BookDto();
		dto.setBookId(13);
		dto.setBookTitle("피카츄");
		dto.setBookAuthor("개발팀");
		dto.setBookPublication("2022-04-23");
		dto.setBookPrice(30500);
		dto.setBookPublisher("알아");
		dto.setBookPage(200);
		dto.setBookGenre("판타지");
		
		BookDao dao = new BookDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("정보 변경 완료");
		}
		else {
			System.out.println("존재하지 않는 번호");
		}
		
	}
}
