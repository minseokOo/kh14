package jdbc.poketmon;

import jdbc.dao.PoketmonDao;

public class Test03삭제 {
	public static void main(String[] args) {
		
		// 삭제
		int poketmonNo = 4;
		
		PoketmonDao dao = new PoketmonDao();
		boolean result = dao.delete(poketmonNo);
		
		if(result) {
			System.out.println("삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 포켓몬 번호");
		}
	}
}
