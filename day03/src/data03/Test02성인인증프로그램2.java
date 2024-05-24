package data03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test02성인인증프로그램2 {

	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = now.format(formatter);
		
		
		System.out.println(formattedDate);
		
		int birth = 19970825;
		int today = Integer.parseInt(formattedDate);
		int krAge = (today / 10000) - (birth / 10000) + 1;
		int adultAge = 20;
		
		boolean able = krAge >= adultAge;
		
		System.out.println(able);
	}

}
