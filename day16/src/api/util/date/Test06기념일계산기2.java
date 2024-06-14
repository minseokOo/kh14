package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test06기념일계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = "2024-06-14";
//		String year = input.substring(0, 4);
//		String month = input.substring(5, 7);
//		String date = input.substring(8, 10);
//		int year1 = Integer.valueOf(year);
//		int month1 = Integer.valueOf(month);
//		int date1 = Integer.valueOf(date);
//		System.out.println(year1 + "년 " + month1 + "월 " + date1 + "일");
		Calendar c = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		int one = 100;
		
	}
}
