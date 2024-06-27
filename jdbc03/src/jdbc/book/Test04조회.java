package jdbc.book;

import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test04조회 {
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		List<BookDto> list = dao.selectList();

		//출력
		System.out.println("개수 : " + list.size());
		for(BookDto dto : list) {
			System.out.println(dto);
		}
	}
}
