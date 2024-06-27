package jdbc.book;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test01등록프로그램 {
	public static void main(String[] args) {
		
		BookDto dto = new BookDto();
		dto.setBookTitle("해리포터");
		dto.setBookAuthor("jk롤링");
		dto.setBookPublication("2014-12-06");
		dto.setBookPrice(30000);
		dto.setBookPublisher("몰라");
		dto.setBookPage(300);
		dto.setBookGenre("판타지");
		
		BookDao dao = new BookDao();
		dao.insert(dto);
		
		System.out.println("등록완료");
	}
}
