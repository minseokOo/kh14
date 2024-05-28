package condition;

import java.util.Scanner;

public class Test07비만판정기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("신장(cm) : ");
		float height = sc.nextFloat();
		float mHeight = height / 100;
		System.out.print("몸무게(kg) : ");
		float weight = sc.nextFloat();
		
		float bmi = weight / (mHeight * mHeight);
		System.out.println("BMI지수는 " + bmi + "입니다.");
		
		if (bmi < 18.5) {
			System.out.println("저체중 입니다.");}
		else if (bmi < 23) {
			System.out.println("정상 입니다.");}
		else if (bmi < 25) {
			System.out.println("과체중 입니다.");}
		else if (bmi < 30) {
			System.out.println("경도비만 입니다.");}
		else {
			System.out.println("중등도비만 입니다.");}
		
		
		
	}
}
