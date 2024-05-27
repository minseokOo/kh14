package data4;

public class Test02문자열 {
	public static void main(String[] args) {
//		문자열(String)
//		- 참조형 데이터(reference type)
//		- 글자 수에 따라 크기가 정해지며 예측이 불가능 하므로 주문 제작 방식
//		-참조변수(리모컨)와 객체(본체)로 나눠져서 제작된다.
		
		String a = "Hello";
		System.out.println(a);
		System.out.println(a.length()); // a 문자열의 글자 개수
		System.out.println(a.charAt(0)); // a 문자열의 문자열의 첫번째 글자를 뽑아라.
		
		
//		특징)
//		- 다른건 안되지만 덧셈은 가능 (연결되어 나옴)
		String b = "자바";
		System.out.println(a + b);
		//System.out.println(a - b); //불가능한 연산
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
//		- 특수문자(Escape Sequence)를 사용 할 수 있다.
		System.out.println("안\n녕\n하\n세\n요"); //\n : 줄바꿈(NewLine)
		System.out.println("안\t녕\t하\t세\t요"); //\t : 탭 이동 (Tap)
//		Tap키는 띄어쓰기와 구분이 되지않아서 \t로 명확하게 표시 할 수 있다.
		
//		(Q) 나는 "피자"를 점심에 먹을 예정입니다. 를 화면에 출력
		System.out.println("나는 \"피자\"를 점심에 먹을 예정입니다.");
		
		
	}

}
