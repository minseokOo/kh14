package loop;

import java.util.Scanner;

public class Test03이름입력기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
		System.out.print("사용자 이름 : ");
		String name = sc.next();
		System.out.println(name + "님 환영합니다!");
		}
		
	}
}
