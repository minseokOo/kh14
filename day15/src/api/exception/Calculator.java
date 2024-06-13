package api.exception;

public class Calculator {
	private Calculator() {}

	// 나누기 메소드
	// - 이 메소드는 항상 정상적으로 실행된다고 보기 어렵다.
	// - b 가 0이면 반드시 예외가 발생한다.
	// - 불확실한, 불안한 메소드
	// - 메소드 끝에 throws Exception 과 같이 작성해서 표시를 한다.
	public static int div(int a, int b) throws Exception {
		return a / b;
	}
}
