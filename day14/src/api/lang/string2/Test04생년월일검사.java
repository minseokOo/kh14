package api.lang.string2;

import java.util.Scanner;

public class Test04생년월일검사 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일을 입력하세요(yyyymmdd) : ");
		int birthday = sc.nextInt();
		
		int year = birthday / 10000;
		int month = birthday %10000 / 100;
		int day = birthday % 100;
		
		String year1 = Integer.toString(year);
		String month1 = Integer.toString(month);
		String day1 = Integer.toString(day);
		
		String regexYear = "^(1[9][0-9]{2})|(20([0-1][0-9])|2[0-3])$";
		String regexMonth = "^(1[0-2])|[1-9]$";
		String regexDay = "^[1-9]|[1-2][0-9]|3[0-1]$";
//		System.out.println(year1.matches(regexYear));
//		System.out.println(month1.matches(regexMonth));
//		System.out.println(day1.matches(regexDay));
		
		if(year1.matches(regexYear)&&month1.matches(regexMonth)
				&&day1.matches(regexDay)){
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
				
		
}
}
