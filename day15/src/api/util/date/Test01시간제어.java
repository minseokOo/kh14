package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

//java.lang 패키지만 import 를 생략 할 수 있다.

public class Test01시간제어 {
	public static void main(String[] args) {
		//Date 클래스
		
		Date a = new Date();
		Date b = new Date(2024, 6, 13);
		Date c = new Date(124, 5, 13);
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
		//시간의 형식이 마음에 들지 않기 때문에 변경 도구를 사용
		// -> java.text.SimpleDateFormat
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(a));
		
		
		
	}
}
