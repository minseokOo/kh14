package jdbc.poketmon;

import java.util.List;

import jdbc.dao.PoketmonDao;
import jdbc.dto.PoketmonDto;

public class Test05검색 {
	public static void main(String[] args) {
		// 입력
		String column = "poketmon_name";
		String keyword = "몬";
		
		// 처리
		PoketmonDao dao = new PoketmonDao();
		List<PoketmonDto>list = dao.selectList(column, keyword);
		
		// 출력
		System.out.println("결과 수 : " + list.size());
		for(PoketmonDto dto : list) {
			System.out.println(dto);
		}
		
	}
}
