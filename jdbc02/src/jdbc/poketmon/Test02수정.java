package jdbc.poketmon;

import jdbc.dao.PoketmonDao;
import jdbc.dto.PoketmonDto;

public class Test02수정 {
	public static void main(String[] args) {
		
		// 준비
		PoketmonDto dto = new PoketmonDto();
		dto.setPoketmonNo(1);
		dto.setPoketmonName("바꾼이름");
		dto.setPoketmonType("체인지");
		
		// 처리
		PoketmonDao dao = new PoketmonDao();
		boolean result = dao.update(dto);
		
		//출력 
		if(result) {
			System.out.println("포켓몬 정보 변경 완료");
		}
		else {
			System.out.println("존재하지 않는 포켓몬 번호");
		}
		
	}
}
