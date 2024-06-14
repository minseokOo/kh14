package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test06기념일계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = "2024-06-14";
		String year = input.substring(0, 4);
		String month = input.substring(5, 7);
		String date = input.substring(8, 10);
		int year1 = Integer.valueOf(year);
		int month1 = Integer.valueOf(month);
		int date1 = Integer.valueOf(date);
		//System.out.println(year1 + "년 " + month1 + "월 " + date1 + "일");
		
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(fmt.format(d));
		
			int hund[] = new int[] {100,200,300,400,500,600,700,800,900,1000};
			
			//c.add(Calendar.DATE, hund);
			for(int i = 0; i < hund.length; i++) {
			c.set(year1, month1-1, date1 + hund[i]);
			Date d = c.getTime();
			System.out.println(hund[i] + "일 : " + fmt.format(d));
			}
			
		
		
		
	}
}
