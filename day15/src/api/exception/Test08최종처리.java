package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test08최종처리 {
	public static void main(String[] args) {
		
		//finally 구문
		// - 반드시 사용해야 하는 구문이 아님
		// - try 실행 후 예외 여부와 관계 없이 실행할 코드를 작성
		Scanner sc = new Scanner(System.in);
		
		
		try {
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
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			sc.close();
		}
	}
}
