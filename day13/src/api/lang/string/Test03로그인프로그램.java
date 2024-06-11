package api.lang.string;

import java.util.Scanner;

public class Test03로그인프로그램 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuffer id = new StringBuffer("khadmin");
		StringBuffer password = new StringBuffer("12312");
		
		System.out.print("아이디를 입력하세요 : ");
		String a = sc.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String b = sc.next();
		
		if(id.toString().equals(a) && password.toString().equals(b)) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
}
