package oop.keyword5;

import java.util.Random;

//변형클래스 - 상수만 보관하는 클래스
public class RSP {
	static final int 가위 = 0;
	static final int 바위 = 1;
	static final int 보 = 2;
	
	public static int generate() {
Random r = new Random();
		int choice = r.nextInt(3);
		return choice;
	}
}
