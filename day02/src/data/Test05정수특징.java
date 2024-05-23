package data;

public class Test05정수특징 {
	public static void main(String[] args) {
		//1. 정수끼리 계산하면 정수가 나옴
		// '/'는 몫을 구할 수 있고 '%'는 나머지를 구할 수 있다.
		System.out.println(10 / 3);
		System.out.println(10 % 3);
		
		//2. 정수는 종류가 여러 가지이고, 표현 가능한 범위가 다르다.
		//- 실제로는 4종류가 있다. (byte / short / int / long)
		//- 정수의 기본값은 int이다. 따라서 더 큰 값에는 long임을 표시해야 한다.
		//- 만약 계산하다 단위를 넘어가면 뒤집힘 현상이 있다.
		
		int a = 1234567 * 1234567;
		long b = 9999999999L;
		System.out.println(a);
		System.out.println(b);
		
		long c = 1234567 * 1234567L;
		System.out.println(c);
	}
}
