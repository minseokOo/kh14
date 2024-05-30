package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test07구구단게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int score = 0;
		int life = 3;

		while (true) {
			int gugu = r.nextInt(18) + 2;
			int guguOne = gugu % 10;
			int guguTen = gugu / 10;
			int gugu2 = r.nextInt(19) + 1;
			int gugu2One = gugu2 % 10;
			int gugu2Ten = gugu2 /10;
			int question = gugu * gugu2;
			
			System.out.print( gugu + " x " + gugu2 + " = ");
			int answer = sc.nextInt();
			if (question == answer) {
				score++;
				System.out.println("현재 점수 : " + score);
				//
			} else {
				life -= 1;
				System.out.println("현재 점수 : " + score);
				System.out.println("남은 목숨 : " + life);
			}
			if (life ==0 ) {
				System.out.println("GAME OVER");
				break;
			}
		}
		System.out.println("총 점수 : " + score + "점");

		
	}
}
