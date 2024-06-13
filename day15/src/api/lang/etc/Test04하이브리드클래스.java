package api.lang.etc;

public class Test04하이브리드클래스 {
	public static void main(String[] args) {
		//정식 명칭은 Wrapper class
		// - 원시형 자료형을 클래스 차원에서 이용 할 수 있도록 만든 것
		// - boolean, byte, short, int, long, float, double, char
		// - 예제에서는 int 와 integer 를 학습
		
		//객체 생성
		Integer a = new Integer(10); //비추천(Deprecated) - Java 9+
		Integer b = new Integer("10"); //비추천(Deprecated) - Java 9+
		Integer c = Integer.valueOf(10); //추천
		Integer d = Integer.valueOf("10"); //추천
		System.out.println(c);		
		
		//Int 가 있는데 Integer 를 쓰는 이유
		// 1. 덧셈 (10 + 20)
		int v1 = 10;
		int v2 = 20;
		int v3 = v1 + v2;
		System.out.println(v3);
		
		Integer x1 = Integer.valueOf(10);
		Integer x2 = Integer.valueOf(20);
		Integer x3 = Integer.sum(x1, x2);
		System.out.println(x3);
		
		
		// 2. 2진수 변환 (100을 2진수로 변환)
		StringBuffer buffer = new StringBuffer();
		for(int i=100; i > 0; i/=2) {
			buffer.insert(0, i%2);//맨 앞에 붙여라
		}
		System.out.println(buffer);
		
		System.out.println(Integer.toBinaryString(100));
		
	}
}
