package io;

public class Test01표준출력 {
	public static void main (String[] args) {
		
//		I/O (Input/Output, 입출력)
//		System.out.println은 무슨 뜻인가?
		
//		System.out 은 표준 출력 통로를 의미
		
		System.out.println("한 줄에 걸쳐 출력하는 명령");
		System.out.println(100 + 200 + 300);
		
		System.out.print("메세지를 ");
		System.out.print("계속해서 ");
		System.out.print("이어서 출력합니다");

//		System.out.print("\n");
		System.out.println();
		
//		C언어 스타일 출력구문(사용안함)
		System.out.printf("%d + %d = %d\n", 10, 20, 30);
		
		
	}
}
