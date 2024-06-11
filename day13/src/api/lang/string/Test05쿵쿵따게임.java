package api.lang.string;

import java.util.Scanner;

public class Test05쿵쿵따게임 {
	public static void main(String[] args) {
		
		
		String start = "바나나";
		int score = 0;
		
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.print(start + "! 쿵쿵따 : ");
		String input = sc.next();
		
		
		if(input.length() == 3 && start.charAt(2) == input.charAt(0)) {
			start = input;
			score++;
		}
		else {
			System.out.println("패배했습니다.");
			System.out.println("맞은 개수 : " + score + "점");
			break;
		}
		}
		
	}
}
