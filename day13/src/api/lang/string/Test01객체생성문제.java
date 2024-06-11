package api.lang.string;

public class Test01객체생성문제 {
	public static void main(String[] args) {
		
		//객체 생성
		StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer("hello");
		
		//요약 정보 출력
		System.out.println(a.toString());
		System.out.println(b); //b 만 적어도 b.toString 을 실행시켜줌
		
		//글자 수 출력
		System.out.println("a의 글자수 = " + a.length());
		System.out.println("b의 글자수 = " + b.length());
		
		//글자 추가
		a.append("java");
		b.append("java");
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("a의 글자수 = " + a.length());
		System.out.println("b의 글자수 = " + b.length());
		
	}
	
}
