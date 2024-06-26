package jdbc.poketmon;

import jdbc.dao.PoketmonDao;
import jdbc.dto.PoketmonDto;

public class Test06상세 {
	public static void main(String[] args) {
		//입력
		int poketmonNo = 5;
		
		//처리
		PoketmonDao dao = new PoketmonDao();
		PoketmonDto dto = dao.selectOne(poketmonNo);
		
		//출력
		if(dto == null) {
			System.out.println("해당 몬스터가 존재하지 않습니다.");
		}
		else {
			System.out.println("이름 : " + dto.getPoketmonName());
			System.out.println("속성 : " + dto.getPoketmonType());
		}
		
	}
}
