package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test07구구단게임2 {

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
			int gugu2Ten = gugu2 / 10;
			int question = gugu * gugu2;

			System.out.print(gugu + " x " + gugu2 + " = ");
			int answer = sc.nextInt();
			if (guguOne > 6 && gugu2One > 6 && question == answer) {
				score += 25;
				System.out.println("+25점! 현재 점수 : " + score);
			} else if (guguOne > 6 && gugu2Ten == 1 && question == answer) {
				score += 15;
				System.out.println("+15점! 현재 점수 : " + score);
			} else if (gugu2One > 6 && guguTen == 1 && question == answer) {
				score += 15;
				System.out.println("+15점! 현재 점수 : " + score);

			} else if (guguTen == 1 && guguTen == 1 && guguOne>2 && gugu2One > 2 && question == answer) {
				score += 15;
				System.out.println("+15점! 현재 점수 : " + score);

			} else if (question == answer) {
				score += 10;
				System.out.println("+10점! 현재 점수 : " + score);
				//
			} else {
				life -= 1;
				System.out.println("현재 점수 : " + score);
				System.out.println("남은 목숨 : " + life);
			}
			if (life == 0) {
				System.out.println("GAME OVER");
				break;
			}
		}
		System.out.println("총 점수 : " + score + "점");

	}
}
