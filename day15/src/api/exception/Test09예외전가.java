package api.exception;

public class Test09예외전가 {
	public static void main(String[] args) {
		//일반적인 프로그램은 main 만 사용하지 않는다
		
		try {
		int a = 10;
		int b = 0;
		int c = Calculator.div(a, b);
		System.out.println("c = " + c );
		}
		catch(Exception e) {
			System.err.println("오류 발생!");
		}
		
		}
}
