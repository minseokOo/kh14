package api.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test04피시방요금계산기 {
	public static void main(String[] args) {
		
		String startTime = "01:20";
		String endTime = "08:30";
		//int startTime2 = Integer.
		
		LocalTime start = LocalTime.parse(startTime);
		LocalTime end = LocalTime.parse(endTime);
		Duration between = Duration.between(start, end);
		
		System.out.println(between.getSeconds());
		
//		int hour = (int)between.getSeconds() / 3600;
//		int minute = (int)between.getSeconds() % 3600 / 60;
		long hour = between.toHoursPart();
		int minute = between.toMinutesPart();
		long minutes = between.toMinutes();
		
		int pricePerHour = 1000;
		float pricePerMinute = pricePerHour / 60f;
		float price = minutes * pricePerMinute;
		int price2 = (int) price;
		
		System.out.println("이용시간 : " + hour + "시간 " + minute + "분");
		System.out.println("사용 요금 : " + price2 + "원");
	}
}
