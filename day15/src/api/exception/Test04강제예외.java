package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04강제예외 {
	public static void main(String[] args) {
		//자바가 감지하지 못하지만 예외로 볼 수 있는 상황을 처리
		//(ex) 음수를 입력하는 경우
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 : ");
		int money = sc.nextInt();
		//문제가 될 경우 catch 블록으로 이동시키도록 코드를 작성
		if(money <= 0) {
			//catch 로 보냄
			throw new Exception();
		}
		
		System.out.print("인원 : ");
		int people = sc.nextInt();
		if(people < 0) {
			//catch 로 보냄
			throw new Exception();
		}
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
