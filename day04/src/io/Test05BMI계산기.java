package io;

import java.util.Scanner;

public class Test05BMI계산기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("신장(cm)을 입력하세요.");
		int height = sc.nextInt(); //cm
		float heightM = (float) height / 100;
		System.out.println("체중(kg)을 입력하세요.");
		int weight = sc.nextInt(); //kg
		
		float BMI = (float)weight / (heightM * heightM);
		
		System.out.println("BMI지수 : " + BMI);
	}
}
