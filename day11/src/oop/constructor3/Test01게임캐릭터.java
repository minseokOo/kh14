package oop.constructor3;

import java.util.Scanner;

public class Test01게임캐릭터 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("캐릭터 이름을 입력하세요. : ");
		String name = sc.next();
		System.out.println("캐릭터 직업을 입력하세요. : ");
		String job = sc.next();
		
		Game g1 = new Game(name, job);
		
		g1.info();
	}
}
