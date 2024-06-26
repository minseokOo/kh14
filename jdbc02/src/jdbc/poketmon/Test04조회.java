package jdbc.poketmon;

import java.util.List;

import jdbc.dao.PoketmonDao;
import jdbc.dto.PoketmonDto;

public class Test04조회 {
	public static void main(String[] args) {
		PoketmonDao dao = new PoketmonDao();
		List<PoketmonDto> list = dao.selectList();

		//출력
		System.out.println("개수 : " + list.size());
		for(PoketmonDto dto : list) {
			System.out.println(dto);
		}
	}
}
