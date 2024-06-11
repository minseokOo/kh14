package api.lang.object;

import java.util.Scanner;

public class Test03최상위클래스 {
	public static void main(String[] args) {
		//최상위 클래스 = 아무 데이터나 보관이 가능하다 (업캐스팅)
		//Object 는 형태에 상관없이 아무 데이터나 보관 가능
		
		Object a = 10;
		Object b = "hello";
		Object c = 3.14;
		Object d = new int[5];
		Object sc = new Scanner(System.in);
		Object st = new Student();
		
	}
}
