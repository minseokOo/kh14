package jdbc.emp;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test06상세 {
	public static void main(String[] args) {
		
		int empNo = 3;
		
		EmpDao dao = new EmpDao();
		EmpDto dto = dao.selectOne(empNo);
		
		if(dto == null) {
			System.out.println("해당 사원은 존재하지 않습니다.");
		}
		else {
			System.out.println("이름 : " + dto.getEmpName());
			System.out.println("소속 : " + dto.getEmpDept());
			System.out.println("입사일 : " + dto.getEmpDate());
			System.out.println("직급 : " + dto.getEmpRank());
			System.out.println("월급 : " + dto.getEmpSal());
		}
	}
}
