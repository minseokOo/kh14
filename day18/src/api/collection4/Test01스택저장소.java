package api.collection4;

import java.util.Stack;

public class Test01스택저장소 {
	public static void main(String[] args) {
		// Stack(스택)
		// - 사용 방법이 정해져 있는 저장소
		// - 마지막에 들어온 데이터가 먼저 나간다 (LIFO, Last-In-First-Out)
		
		// List<String> stack = new Stack<>();
		Stack<String> stack = new Stack<>();
		
		stack.push("뽀로로");
		stack.push("크롱");
		stack.push("루피");
		stack.push("패티");
		
		// 가장 마지막에 들어간 데이터 확인 - peek()
		System.out.println("맨 앞 = " + stack.peek());
		
		//데이터 제거 - pop()
		stack.pop();
		stack.pop();
		System.out.println("맨 앞 = " + stack.peek());
		
	}
}
