package random;

import java.util.Random;

public class Test01랜덤 {

	public static void main(String[] args) {
		//랜덤(Random)
//		- 예측이 불가능한 값
//		- 프로그래밍에서는 유사 랜덤값을 계산하는 형태로 랜덤 데이터를 구함
//		- Random 이라는 이름의 도구가 존재
//		- 범위가 있음 (?부터 ?개로 표현)
		
		Random r = new Random(); //창조형(reference)
		
		int a = r.nextInt(); //무작위 int 값을 한 개 주세요.
		
		System.out.println("a = " + a);
		
		int b = r.nextInt(6) + 1; //r.nextInt(개수) + (시작숫자) //1부터 6개
		
		System.out.println("주사위 = " + b);
		
		int c = r.nextInt(900) + 100;
		
		System.out.println("랜덤 세자리 정수 = " + c);
		
		int d = r.nextInt(45) + 1;
		
		System.out.println("랜덤 로또 숫자 = " + d);
		
//		(Q) 동전 1개를 던진 결과를 화면에 출력하세요 ( 앞 / 뒤 )
//		- 약속 : 앞(1), 뒤(2) -> 1부터 2개
		int coin = r.nextInt(2) + 1;
		System.out.println("coin = " + coin);
		
		if(coin == 1) {
			System.out.println("앞");
		}
		else {
			System.out.println("뒤");
		}
	}
}
