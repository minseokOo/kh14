package jdbc.book;

import jdbc.dao.BookDao;

public class Test03삭제 {
	public static void main(String[] args) {

		int bookId = 14;

		BookDao dao = new BookDao();
		boolean result = dao.delete(bookId);

		if (result) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("존재하지 않는 포켓몬 번호");
		}
	}
}
