package oop.poly01_2;

import java.util.Scanner;

public class Test01다형성을사용하는풀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사용하실 노트북을 선택하세요.");
		System.out.println("1. 맥북 2. 갤럭시북");
		int kind = sc.nextInt();
		System.out.println("사용하실 기능을 선택하세요.");
		System.out.println("1. 전원 2. 비디오 3. 타이핑");
		int action = sc.nextInt();

		// NoteBook pc = 맥북 or 갤럭시북;
		NoteBook pc;
		if (kind == 1) {
			pc = new MacBook();
		} else {
			pc = new GalaxyBook();
		}
		// System.out.println(pc);

		if (action == 1) {
			pc.power();
		} else if (action == 2) {
			pc.video();
		} else {
			pc.typing();
		}
	}
}
