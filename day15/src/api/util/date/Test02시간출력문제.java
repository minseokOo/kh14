package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02시간출력문제 {
	public static void main(String[] args) {
		
		Date now = new Date();
		
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		System.out.println(year.format(now) + "년 " + month.format(now)
									+ "월 " + day.format(now) + "일");
		
		SimpleDateFormat afterNoon = new SimpleDateFormat("h");
		SimpleDateFormat minute = new SimpleDateFormat("m");
		SimpleDateFormat amPm = new SimpleDateFormat("a");
		System.out.println(amPm.format(now) + afterNoon.format(now) + "시 " + minute.format(now) + "분");
		
		SimpleDateFormat time = new SimpleDateFormat("kk:mm:ss");
		System.out.println(time.format(now));
		
		SimpleDateFormat year2 = new SimpleDateFormat("yyyy-MM-dd E kk:mm:ss");
		System.out.println(year2.format(now));
		
	
	}
}
