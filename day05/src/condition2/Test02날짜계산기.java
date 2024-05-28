package condition2;

import java.util.Scanner;

public class Test02날짜계산기 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int today = sc.nextInt();
		int month = (today % 10000) / 100;
		int year = today / 10000;
		
		boolean a = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		boolean b = month == 2;
		boolean c = a == true && b == true;
		
		
		//윤년이고 2월일때 = 29일
		if (c) {
			System.out.println("29일(윤년)");
		}

		switch (month) {
		
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : 
			System.out.println("큰달");
		break;
			
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			System.out.println("작은달");
			
		break;
		
		case 2 :
			System.out.println("28일");
			break;	
		}
		
	}
}
