package api.time;

import java.time.LocalDate;
import java.time.Period;

public class Test01타임패키지 {
	public static void main(String[] args) {
		//Calendar 의 문제점
		// 1. 월을 설정하기가 불편하다. (-1, +1)
		// 2. 메소드의 용도를 파악하기가 어렵다. (자바 표준 이름이 아님)
		// 3. 윤년을 알기가 어렵다.
		// 4. (중요) 날짜가 변한다.
		// 5. 시간차를 구하기가 힘들다.
		// 6. 날짜와 시간이 합쳐져 있다.
		
		//위의 불편사항들을 모두 개선해서 자바8에서 java.time 패키지가 나옴
		// - LocalDate - 날짜만 필요할 때 사용하는 클래스
		// - LocalTime - 시간만 필요할 때 사용하는 클래스
		// - LocalDateTime - 둘 다 필요할 때 사용하는 클래스
		
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.of(2000, 1, 1));
		
		LocalDate a = LocalDate.now();
		System.out.println("연도 = " + a.getYear());
		System.out.println("월 = " + a.getMonthValue());
		System.out.println("일 = " + a.getDayOfMonth());
		
		LocalDate b = LocalDate.of(2024, 11, 12);
		LocalDate project = b.minusDays(21); //3주전
		System.out.println(project);
		
		
		// (Q) 수료일 까지 남은 일수를 구하세요
		// - a, b 모두 주인공이 아니므로 별도의 클래스로 계산
		// - Period 클래스
		Period period = Period.between(a, b);
		System.out.println(period);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		
		//윤년인가?
		System.out.println(a.isLeapYear());
		
	}
}
