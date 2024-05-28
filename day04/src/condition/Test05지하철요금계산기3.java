package condition;

import java.util.Scanner;

public class Test05지하철요금계산기3 {

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
		int free = 0;
		int deposit = 500;
		
		
		System.out.print("지하철 요금은 ");
		int price;
		if (age >= 20 && age < 65) { //성인
			price = adultPrice; }
		
			else if (age >= 14) { //청소년
				price = teenagePrice;}
		
			else if (age >= 8) { //어린이
				price = childrenPrice;}
		
				else {price = free;}
		
		//카드 보증금 추가 (모든 경우)
		price += deposit;
		
		
				System.out.println(price + "원 입니다.");
		
				
			
		
		
		
		
		
		
	}
}
