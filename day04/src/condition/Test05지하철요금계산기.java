package condition;

import java.util.Scanner;

public class Test05지하철요금계산기 {

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
		
		if (age >= 20 && age < 65) { //성인
			System.out.println(adultPrice + deposit + "원 입니다.");
		}
			else if (age >= 14 && age < 20) { //청소년
			System.out.println(teenagePrice + deposit + "원 입니다.");	
			}
				else if (age >= 8 && age < 14) { //어린이
				System.out.println(childrenPrice + deposit + "원 입니다.");
				}
				else
				{System.out.println("지하철 요금은 " + deposit + "원 입니다");
				
		}
		
		
		
		
		
		
	}
}
