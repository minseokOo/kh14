package condition;

import java.util.Scanner;

public class Test05지하철요금계산기2 {

	public static void main(String[] args) {
		
		System.out.print("출생년도 : ");
		Scanner sc = new Scanner(System.in);
		
		int birth = sc.nextInt();
		int now = 2024;
		
		int age = now - birth +1;
		System.out.println("나이 : " + age + "세");
		
		int adultPrice = 1400;
		int teenagePrice = 800;
		int childrenPrice = 500;
		int deposit = 500;
		
		System.out.print("지하철 요금은 ");
		if (age >= 20 && age < 65) { //성인
			System.out.print(adultPrice + deposit);}
		
			else if (age >= 14) { //청소년
			System.out.print(teenagePrice + deposit);}	
		
			else if (age >= 8) { //어린이
				System.out.print(childrenPrice + deposit);}
		
				else {System.out.print(deposit);}
		
				System.out.println("원 입니다.");
		
				
			
		
		
		
		
		
		
	}
}
