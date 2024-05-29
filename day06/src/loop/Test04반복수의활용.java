package loop;

public class Test04반복수의활용 {

	public static void main(String[] args) {
		//반복수란
//		- 반복을 위해 만든 변수 (ex. i )
//		- 반복 구문 내에서 이 변수를 사용 할 수 있음
//		- 반복을 이용해서 "원하는 구간"에 대한 작업을 수행 할 수 있다.
		
		for(int i = 0; i < 5; i++) {//변수 i 는 이 블록 내에서만 사용 가능
			System.out.println("i = " +i);
		}
		
		System.out.println("----------------");
		
		//10부터 1까지 출력하는 반복문
		for(int i = 10; i > 0 ; i--) {
		System.out.println("i = " +i);
		}
		
		System.out.println("______________");
		
		for(int i = 1; i <= 10; i = i+2) {
			System.out.println("i = " + i);
		}
		
		System.out.println("______________");
		
		for(int i = 1; i <= 10; i++) {
			if( i % 2 != 0) {
			System.out.println("홀수 = " + i);
		}
		}
	}
}
