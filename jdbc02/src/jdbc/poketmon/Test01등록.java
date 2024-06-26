package jdbc.poketmon;

import jdbc.dao.PoketmonDao;
import jdbc.dto.PoketmonDto;

public class Test01등록 {
	public static void main(String[] args) {
		
		PoketmonDto dto = new PoketmonDto();
		dto.setPoketmonName("홍수몬");
		dto.setPoketmonType("물");
		
		PoketmonDao dao = new PoketmonDao();
		dao.insert(dto);

		System.out.println("등록완료");
	}
	
	
}
