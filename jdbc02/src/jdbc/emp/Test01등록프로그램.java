package jdbc.emp;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test01등록프로그램 {
	public static void main(String[] args) {
		
		EmpDto dto = new EmpDto();
		dto.setEmpName("김사원");
		dto.setEmpDept("영업팀");
		dto.setEmpDate("2023-06-14");
		dto.setEmpRank("대리");
		dto.setEmpSal(3000000);
		
		EmpDao dao = new EmpDao();
		dao.insert(dto);
		
		System.out.println("등록완료");
	}
}
