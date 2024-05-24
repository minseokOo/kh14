package data03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test05건강검진대상자판정 {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String today = now.format(formatter);
		
        int todayInt = Integer.parseInt(today);
        
		int birth = 19880825;
		int age = todayInt / 10000 - birth / 10000;
		int yearNow = todayInt / 10000;
		boolean evenYearNow = yearNow % 2 == 0;
		boolean evenAge = age % 2 == 0;
		
		boolean a = evenYearNow == evenAge;
		
		System.out.println(a);
		
	}

}
