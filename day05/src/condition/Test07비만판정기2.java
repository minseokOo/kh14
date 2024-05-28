package condition;

import java.util.Scanner;

public class Test07비만판정기2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("신장(cm) : ");
		float height = sc.nextFloat();
		float mHeight = height / 100;
		System.out.print("몸무게(kg) : ");
		float weight = sc.nextFloat();
		
		float bmi = weight / (mHeight * mHeight);
		System.out.println("BMI지수는 " + bmi + "입니다.");
		
		String result;
		if (bmi < 18.5f) {
			result = "저체중";}
		else if (bmi < 23f) {
			result = "정상";}
			else if (bmi < 25f) {
			result = "과체중";}
		else if (bmi < 30f) {
			result = "경도비만";}
		else {
			result = "중등도비만";}
		
		System.out.println("결과는 " + result + " 입니다.");
		
	}
}
