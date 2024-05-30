package loop3;

public class Test01누적합계 {

	public static void main(String[] args) {
//		(Q) 10을 10번 더하면 얼마인가요?
		int a = 0;
		for(int i=0; i < 10; i++) {
			a += 10;
		}
		System.out.println(a);
		
//		(Q) 1부터 10까지 더하면 얼마인가요?
		int b = 0;
		for(int i = 1; i <= 10; i++) {
			b += i;
		}
		System.out.println(b);
		
	}
}
