package api.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Test02예약날짜선택기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("예약 희망하시는 날짜를 YYYY-MM-DD 형태로 입력해주세요");
		String input = sc.next();
		//String input = "2024-07-01";
		
//		int year = Integer.valueOf(input.substring(0, 4));
//		int month = Integer.valueOf(input.substring(5, 7));
//		int date = Integer.valueOf(input.substring(8, 10));
		//System.out.println(month);
		//LocalDate inputDate = LocalDate.of(year, month, date);
		LocalDate inputDate = LocalDate.parse(input);
		//System.out.println(inputDate);
		LocalDate now = LocalDate.now();
		//System.out.println(now);
//		int nowYear = now.getYear();
//		int nowMonth = now.getMonthValue();
//		int nowDate = now.getDayOfMonth();
		
		//boolean isFuture = inputDate.isAfter(now);
		boolean isBefore = inputDate.isBefore(now);
		// 주말인지 판정
		System.out.println(inputDate.getDayOfWeek().getValue());
		System.out.println(inputDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		boolean isHoliday = inputDate.getDayOfWeek()
				.getDisplayName(TextStyle.SHORT, Locale.KOREAN).matches("^[토일]$");
		
		//System.out.println(inputDate.isAfter(now));
		if(isBefore|| isHoliday ) {
			System.out.println("현재 날짜 : " + now + "일");
			System.out.println("예약 희망일 : " + inputDate + "일");
			System.out.println("예약 불가능한 날짜 입니다.");
		}
		else {
			System.out.println("현재 날짜 : " + now + "일");
			System.out.println("예약 희망일 : " + inputDate + "일");
			System.out.println("예약 가능한 날짜 입니다.");
		}
	}
}
