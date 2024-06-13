package api.lang.etc;

import java.util.Random;

public class Test01수학계산클래스 {
	public static void main(String[] args) {
		//Math 클래스
		// - 객체 생성이 불가능한 클래스
		// - 일회성 계산 기능 메소드만 가지고 있는 클래스(AutoCalculator랑 비슷)
		//Math m = new Math() {}
		
		int car1 = 55;
		int car2 = 80;
		//(Q) 두 자동차의 속도 차이는?
//		int answer = car2 - car1;
//		System.out.println("정답 : " + answer);
		
//		if(car2 > car1) {
//			System.out.println(car2-car1);
//		}
//		else {
//			System.out.println(car1-car2);
//		}
		
		System.out.println(Math.abs(car1 - car2)); //절대값
		
		double a = 1.4;
		double b = 1.5;
		System.out.println((int)(a + 0.5));//반올림
		System.out.println((int)(b + 1));//올림
		System.out.println(Math.round(a));//반올림
		System.out.println(Math.ceil(b));//올림
		
		//제곱 계산 : 2^10 = 1024
		int n = 1;
		for(int i=0; i < 10; i++) {
			n *= 2;
		}
		System.out.println(n);
		System.out.println((int)Math.pow(2, 10));
		
		//(Q) 주사위 두개를 던져서 큰 값과 작은 값을 각각 출력하세요
		
		Random r = new Random();
		int r1 = r.nextInt(6)+1;
		int r2 = r.nextInt(6)+1;
		
		if(r1>r2) {
		System.out.println("큰 주사위 = " + r1);
		System.out.println("작은 주사위 = " + r2); 
		}
		else {
			System.out.println("큰 주사위 = " + r2);
			System.out.println("작은 주사위 = " + r1);
		}
		System.out.println("큰 주사위 = " + Math.max(r1, r2));
		System.out.println("작은 주사위 = " + Math.min(r1, r2));
		
		//그 외에도 삼각함수, 각도변환 등 다양한 기능을 제공
		
		System.out.println(Math.PI);
	}
}
