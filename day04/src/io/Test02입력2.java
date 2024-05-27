package io;

//import는 사용 가능한 도구의 위치를 알려주는 구문(준비구문)
import java.util.Scanner;

public class Test02입력2 {

	public static void main(String[] args) {
		
//		(Q) 짜장면 1그릇이 7천원일 때 5그릇의 가격은?
		
		//사용자에게 키보드 입력을 받기 위해서는 특별한 도구가 필요
		//(몇 글자 입력할지 모르기 때문)
		Scanner sc = new Scanner(System.in); 
		
		//입력
		int jjaPrice = 7000;
		System.out.println("주문하실 짜장면 수량을 입력하세요");
		int jjaCount = sc.nextInt();//사용자가 키보드로 입력하라.
		//int - nextInt, double - nextDouble, float - nextFloat
		
		//처리
		int total = jjaPrice * jjaCount;
		
		//출력
		System.out.println("금액 : " + total + "원");
		
	}
}
