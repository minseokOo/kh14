package data4;

import java.util.Scanner;

public class Test03평균계산기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어점수 : ");
		int korean = sc.nextInt();
		System.out.println("영어점수 : ");
		int english = sc.nextInt();
		System.out.println("수학점수 : ");
		int math = sc.nextInt();
		
		int total = (korean + english + math);
		System.out.println("총점 : " + total + "점");
		
		double avg = (double)total / 3;
		
		System.out.println("평균 : " + avg + "점");
		
		
	}
}
