package api.time;

import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ofPattern;

public class Test03날짜출력형식 {
	public static void main(String[] args) {
		//날짜 출력 시 형식 지정이 가능한가? (SimpleDateFormat 처럼....)
		// - SimpleDateFormat 대신 다른 도구가 있다(DateTimeFormatter)
		
		LocalDate a = LocalDate.parse("2024-06-14");
		
		System.out.println(a);
		
		//DateTimeFormatter fmt = DateTimeFormatter.ofPattern("y년 M월 d일");
		System.out.println(a.format(ofPattern("y년 M월 d일")));
		
	}
}
