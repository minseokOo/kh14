package condition2;

import java.util.Scanner;

public class Test03학점계산기 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		int sco = score / 10;
		
		
		
		switch(sco) {
		
		case 9 :
		case 10 :
			System.out.println("A 학점");
		break;
		
		case 8 : 
			System.out.println("B 학점");
		break;
		
		case 7 :
			System.out.println("C 학점");
		break;
		
		default : 
			System.out.println("F 학점");
		break;
		
		
		
		}
		
	}
}
