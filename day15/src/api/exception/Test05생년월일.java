package api.exception;

import java.util.Scanner;

public class Test05생년월일 {
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		
		String birth = sc.nextLine();
		String year = birth.substring(0, 4);
		String month = birth.substring(5, 7);
		String day = birth.substring(8, 10);
		
		
		Integer year1 = Integer.valueOf(year);
		Integer month1 = Integer.valueOf(month);
		Integer day1 = Integer.valueOf(day);
			boolean isLeap = year1 % 4 == 0 && year1 %100 !=0 || year1 % 400 ==0;
			String regex;
			if(isLeap) {
				regex = "^([0-9]{4}|20([01][0-9]|2[0-3]))-(02-(0[1-9]|1[0-9]|2[0-9])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
			}
			else {
				regex = "^([0-9]{4}|20([01][0-9]|2[0-3]))-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
			}
			if(!birth.matches(regex)) {
				throw new Exception();
			}
			boolean isFuture = ( year1 >= 2025) || (year1 == 2024 && month1 >= 7) 
					|| (year1 == 2024 && month1 == 6 && day1 >=13);
			if(isFuture) {
				throw new Exception();
			}
			System.out.println("출생년도 : " + year1 + "년");
			System.out.println("출생월 : " + month1 + "월");
			System.out.println("출생일 : " + day1 + "일");
		}
		catch( Exception e) {
			System.err.println("올바른 생년월일을 입력하세요");
		}
			
		
	}
}

