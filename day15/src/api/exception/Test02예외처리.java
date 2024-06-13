package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02예외처리 {
	public static void main(String[] args) {
		// 예외 처리란 언제 발생할지 모르는 돌발 상황에 대해 플랜B를 작성해두는것
		
		// 플랜A (try)
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 : ");
		int money = sc.nextInt();
		System.out.print("인원 : ");
		int people = sc.nextInt();
		
		int result = money / people;
		System.out.println("한 사람당 " + result + "원을 내야합니다.");
		}
		catch(InputMismatchException e){//잘못된 입력을 했을 때에 대한 플랜B
			System.err.println("숫자만 입력하세요.");
		}
		catch(ArithmeticException e){//인원수가 0일 때에 대한 플랜B
			System.err.println("인원 수는 0보다 커야합니다.");
		}
		 
		
	}
}
