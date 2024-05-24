package data03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test05건강검진대상자판정5 {

	public static void main(String[] args) {


		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String today2 = now.format(formatter);
		
        int today = Integer.parseInt(today2);
        System.out.println(today);
        int birth = 19840101;
        
        int birthYear = birth / 10000;
        int todayYear = today / 10000;
        
        int age = todayYear - birthYear + 1;
        
        boolean over30 = age >= 30;
        
        //짝수년도에 태어났는지
        boolean birthEven = birthYear % 2 == 0;
        System.out.println(birthEven);
        
        //홀수년도에 태어났는지
        boolean birthOdd = birthYear % 2 == 1;
        System.out.println(birthOdd);
        
        //네 번째 조건 - 올해가 짝수해인가요?
        boolean todayEven = todayYear % 2 == 0;
        
        //다섯 번째 조건 - 올해가 홀수해인가요?
		boolean todayOdd = todayYear % 2 == 1;
		
		//케이스1 - 30세 이상이고 짝수년 태생에 짝수해에 건강검진
		boolean case1 = over30 && birthEven && todayEven ;
		
		
		//케이스2 - 30세 이상이고 홀수년 태생에 홀수해에 건강검진
		boolean case2 = over30 && birthOdd && todayOdd ;
		
		boolean answer = case1 || case2;
		
		System.out.println(answer);
	}

}
