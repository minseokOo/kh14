package api.exception;

import java.util.Scanner;

public class Test01예외발생 {
	public static void main(String[] args) {
		//에러(Error) 와 예외(Exception)
		// - 에러는 프로그램이 실행 될 수 없는 상황 (ex : 오타)
		// - 예외는 프로그램 실행 중에 발생하는 돌발 상황 (ex : 잘못된 입력)
		
		// (예) N분의 1 계산기
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 : ");
		int money = sc.nextInt();
		System.out.print("인원 : ");
		int people = sc.nextInt();
		
		int result = money / people;
		System.out.println("한 사람당 " + result + "원을 내야합니다.");
		
	}
}
//Exception in thread "main" java.util.InputMismatchException
//
//
//
//
//