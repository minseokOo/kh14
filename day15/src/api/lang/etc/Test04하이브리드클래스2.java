package api.lang.etc;

public class Test04하이브리드클래스2 {
	public static void main(String[] args) {

		// 서로 호환이 가능
		// int ---> Integer : auto-boxing
		// Integer ---> int : auto-unboxing
		// 1. 덧셈 (10 + 20)
		int v1 = 10;
		int v2 = 20;
		int v3 = v1 + v2;
		System.out.println(v3);
		
		Integer x1 = 10;
		Integer x2 = 20;
		Integer x3 = Integer.sum(x1, x2);
		System.out.println(x3);
		
		
		// 2. 2진수 변환 (100을 2진수로 변환)
		System.out.println(Integer.toBinaryString(100));
		
		//(주의사항)
		// - null 이 나올 수 있다면 반드시 Integer 만 사용해야 한다.
		//int z = null;
		Integer z1 = null;
		
	}
}
