package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03예외통합 {
	public static void main(String[] args) {
		//여러가지의 예외를 하나의 catch 로 해결하는법
		
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
		//catch(Object e){//안됨
		//catch(Throwable e) { 너무 큰 범위를 포함
		catch(Exception e) { // 자바의 모든 예외를 처리
		//catch(RuntimeException e){//자바의 일부 예외
			System.err.println("0 보다 큰 숫자만 입력하세요.");
		}
		
		
	}
}
