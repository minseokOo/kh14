package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String, String> data = new HashMap<>();
		
		data.put("khadmin", "admin1234");
		data.put("khstudent", "student1234");
		data.put("khteacher", "teacher1234");
		data.put("khmanager", "manager1234");
		
		System.out.print("아이디 : ");
		String account = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		sc.close();
		
		
		
		if(data.containsKey(account) && password.equals(data.containsValue(account))) {
			System.out.println("**로그인 성공**");
		}
		else {
			System.out.println("**입력하신 정보가 일치하지 않습니다.**");
		}
		
	}
}
