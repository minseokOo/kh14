package loop5;

import java.util.Scanner;

public class Test01DoWhile반복 {

	public static void main(String[] args) {
		//do-while 반복
//		-for, while과는 다르게 실행 후 검사를 하는 구조의 반복문
		
//		do {
//			코드
//		}
//		while(조건);
		
//		사용자가 올바른 점수를 입력하는 프로그램 (올바른 점수 : 0~100)
		int score;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("점수 입력 : ");
			score = sc.nextInt();
		}
		while(!(score >= 0 && score <= 100));
	}
}
