package loop4;

public class Test01While반복 {

	public static void main(String[] args) {
		//while 반복
//		- for 와 다르게 횟수나 범위가 없는 경우에 사용
//		- for 처럼 사용 할 수 있지만 권장하지는 않음.
		
		for (int i=1 ; i <= 10; i++) {
			System.out.println("i = " + i);
		}
		System.out.println("----------------");
		int n = 1;
		while(n <= 10) {
			System.out.println("n = " + n);
			n++;
		}
		
	}
}
