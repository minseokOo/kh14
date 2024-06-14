package api.util.date;

import java.util.Calendar;

public class Test03캘린더생성 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();

		int year = c.get(Calendar.YEAR);
		//System.out.println(year);
		int month = c.get(Calendar.MONTH) +1; //month 는 0부터 11로 나타남
		//System.out.println(month);
		int day = c.get(Calendar.DAY_OF_MONTH); // == Calendar.DATE
		int hour = c.get(Calendar.HOUR_OF_DAY); // HOUR 는 12시간 방식
		int minute = c.get(Calendar.MINUTE);
		//System.out.println(minute);
		int second = c.get(Calendar.SECOND);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 "
								+ hour + "시 " + minute + "분 " + second + "초");
	}
}
