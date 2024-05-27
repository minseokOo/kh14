package io;

import java.util.Scanner;

public class Test04나이계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("생년월일 8자리를 입력하세요.");
		int birth = sc.nextInt();
		System.out.println("오늘 날짜 8자리를 입력하세요.");
		int today = sc.nextInt();
		
		int birthYear = birth / 10000;
		int todayYear = today / 10000;
		
		int monthBirth = birth % 10000 / 100;
		int monthToday = today % 10000 / 100;
		
		int diffYear = todayYear - birthYear;
		int diffMonth = monthToday - monthBirth;
		
		int difference = diffYear * 12 + diffMonth;
		double Age = (double)difference / 12;
		int Age2 = (int )Age;
		
		System.out.println("만나이 : " + Age2);
		
		int krAge = diffYear + 1;
		
		System.out.println("한국 나이 : " + krAge);
		
		
	}

}
