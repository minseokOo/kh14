package jdbc.emp;

import jdbc.dao.EmpDao;

public class Test03삭제 {
	public static void main(String[] args) {
		
		int empNo = 3;
		
		EmpDao dao = new EmpDao();
		boolean result = dao.delete(empNo);
		
		if(result) {
			System.out.println("삭제완료");
		}
		else {
			System.out.println("존재하지 않는 포켓몬 번호");
		}
	}
}
