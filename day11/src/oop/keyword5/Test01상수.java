package oop.keyword5;

import java.util.Random;

public class Test01상수 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		//약속 - 가위(0), 바위(1), 보(2)
		int choice = r.nextInt(3);
		System.out.println("choice = " + choice);
		
		switch(choice) {
		case 0: System.out.println("가위");break;
		case 1: System.out.println("바위");break;
		case 2: System.out.println("보");break;
		}
		
		
	}
	
}
