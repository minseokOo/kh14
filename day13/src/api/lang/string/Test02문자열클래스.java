package api.lang.string;

public class Test02문자열클래스 {
	public static void main(String[] args) {
		//String 클래스
		// - 문자열을 자바에서 처리하기 위하여 만들어진 클래스
		// - 문자열은 불변(immutable) 특성을 가짐
		
		//객체 생성 (hello 라는 글자를 가진 문자열)
		String a = new String("hello");
		//String a = "hello";
		char[] ch = new char[] {'h', 'e', 'l', 'l', 'o'};
		String b = new String(ch);
		
		StringBuffer sb = new StringBuffer("hello");
		String c = new String(sb);
		
		String d = "hello";
		String e = "hello";
		
		//정보 출력
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		
		System.out.println();
		
		//비교연산은 언제나 일치한다고 보기가 어렵다(운좋으면 되는 수준)
		System.out.println("a랑 b가 같나요? " + (a == b));
		System.out.println("b랑 c가 같나요? " + (b == c));
		System.out.println("c랑 d가 같나요? " + (c == d));
		System.out.println("d랑 e가 같나요? " + (d == e));
		
		System.out.println();
		
		System.out.println("a랑 b가 같나요? " + a.equals( b));
		System.out.println("b랑 c가 같나요? " + b.equals(c));
		System.out.println("c랑 d가 같나요? " + c.equals(d));
		System.out.println("d랑 e가 같나요? " + d.equals(e));
		
		
		
	}
}
