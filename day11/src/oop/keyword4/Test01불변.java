package oop.keyword4;

public class Test01불변 {

	public static void main(String[] args) {
		//불변이란 최초 설정된 이후에 변경이 불가능하게 하는 처리를 말한다.
		//final 이라는 키워드를 붙이면 변수, 메소드, 클래스가 불변이 된다.
		
		final int a = 10;
//		a = 20;
//		a = 30;
		System.out.println(a);
	}
}
