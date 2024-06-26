package jdbc.emp;

import java.util.List;
import java.util.Scanner;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test05검색 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String column = sc.nextLine();
		String keyword = sc.nextLine();
		sc.close();
		
		EmpDao dao = new EmpDao();
		List<EmpDto>list = dao.selectList(column, keyword);
		
		System.out.println("결과 수 : " + list.size());
		for(EmpDto dto : list) {
			System.out.println(dto);
		}
		
	}
}
