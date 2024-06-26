package jdbc.emp;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test02수정 {
	public static void main(String[] args) {
		
		EmpDto dto = new EmpDto();
		dto.setEmpNo(2);
		dto.setEmpName("김대리");
		dto.setEmpDept("개발팀");
		dto.setEmpDate("2022-04-23");
		dto.setEmpRank("과장");
		dto.setEmpSal(3000000);
		
		EmpDao dao = new EmpDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("정보 변경 완료");
		}
		else {
			System.out.println("존재하지 않는 번호");
		}
		
	}
}
