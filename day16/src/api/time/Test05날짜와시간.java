package api.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test05날짜와시간 {
	public static void main(String[] args) {
		
		//LocalDateTime 클래스
		// - 날짜와 시간이 모두 필요할 때 사용 가능한 클래스
		
		//객체 생성
		LocalDateTime t1 = LocalDateTime.now();
		LocalDateTime t2 = LocalDateTime.of(2024, 6, 14, 16, 10, 20);
		LocalDateTime t3 = LocalDateTime.parse("2024-06-14T16:10:20");
		
		DateTimeFormatter fmt = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime t4 = LocalDateTime.parse("2024-06-14 16:10:20", fmt);
		
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		System.out.println("t4 = " + t4.format(fmt));
		
		//t1 과 같은해 1월 1일
		LocalDateTime t5 = t1.withMonth(1).withDayOfMonth(1);
		System.out.println("t5 = " + t5);
		
	}
}
