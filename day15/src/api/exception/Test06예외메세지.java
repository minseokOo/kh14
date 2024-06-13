package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test06예외메세지 {
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
			//throw new Exception();
			throw new Exception("금액은 0보다 커야합니다.");//메세지를 갖고 catch 블록으로 보냄
		}
		
		System.out.print("인원 : ");
		int people = sc.nextInt();
		if(people <= 1) {
			//catch 로 보냄
			throw new Exception("인원은 2명 이상이어야 합니다.");
		}
		int result = money / people;
		System.out.println("한 사람당 " + result + "원을 내야합니다.");
		}
		catch(Exception e) {//null 이 나오면
			if(e.getMessage() == null) {
				System.err.println("오류가 발생했습니다.");
			}
			else {//메세지가 있으면
				System.err.println(e.getMessage());
			}
		}
		
	}
}
