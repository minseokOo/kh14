package data02;

public class Test01실수 {

	public static void main(String[] args) {
//		실수(Floating Number)
//		- float, double 두 종류가 존재
//		- 소수점이 있는 숫자
//		- 기본 형태가 double로 설정됨
//		- 정확하게 계산되지 않음
		
		
		float a = 1.234f; 
		double b = 2.3445;
		System.out.println(a);
		System.out.println(b);
		
//		(중요) 실수가 포함된 계산은 결과가 실수
//		1+1+1.2 = 3.2 (실수), 2 * 1 * 1.2 = 2.4 (실수)
		System.out.println(1.5 + 2.5); // 값은 4.0으로 실수
		System.out.println(10 / 3.0); //double의 자리수 까지만 계산
		System.out.println(10 / 3f);
		System.out.println(10 / 3d);
	}

}
