package oop.poly01;

import java.util.Scanner;

public class Test01다형성을사용하지않은풀이 {

	public static void main(String[] args) {

		//사용자에게 선택을 받는 코드
		Scanner sc = new Scanner(System.in);
		System.out.println("사용하실 노트북 종류를 고르세요");
		System.out.println("1. 맥북 2. 갤럭시북");
		int kind = sc.nextInt();
		System.out.println("사용하실 기능을 선택하세요.");
		System.out.println("1. 전원 2. 비디오 3. 타이핑");
		int action = sc.nextInt();
		
		//kind 와 action 에 따라 필요한 노트북을 만들어서 필요한 기능을 실행
		if(kind == 1) {
			MacBook pc = new MacBook();
			
			if(action == 1) {
				pc.power();
			}
			else if(action == 2) {
				pc.video();
			}
			else if(action == 3) {
				pc.typing();
			}
		}
		else if(kind == 2) {
			GalaxyBook pc = new GalaxyBook();
			
			if(action == 1) {
				pc.power();
			}
			else if(action == 2) {
				pc.video();
			}
			else if(action == 3) {
				pc.typing();
			}
		}
	}

}
