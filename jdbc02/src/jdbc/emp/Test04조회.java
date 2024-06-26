package jdbc.emp;

import java.util.List;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test04조회 {
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.selectList();
		
		System.out.println("개수 : " + list.size());
		for(EmpDto dto : list) {
			System.out.println(dto);
		}
	}
}
