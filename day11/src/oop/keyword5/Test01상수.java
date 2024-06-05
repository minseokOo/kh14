package oop.keyword5;


public class Test01상수 {

	public static void main(String[] args) {
		int choice = RSP.generate();
		
		
		System.out.println("choice = " + choice);
		
		switch(choice) {
		case RSP.가위: System.out.println("가위");break;
		case RSP.바위: System.out.println("바위");break;
		case RSP.보: System.out.println("보");break;
		}
		
		
	}
	
}
