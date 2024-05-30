package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test05배스킨라빈스31 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int count = 0;
		
		System.out.println("현재 숫자 : " + count);
		while (true) {
			if (count < 31) {
				System.out.print("숫자를 입력하세요 : ");
				int a = sc.nextInt();
				if (a > 3) {
					System.out.println("입력 할 수 있는 숫자 : 1, 2, 3");
					count -= a;
				} else if (a <= 0) {
					System.out.println("0보다 큰 수를 입력하세요.");
				} else if (count == 29 && a > 2) {
					System.out.println("입력 할 수 있는 숫자 : 1, 2");
					count -= a;
				} else if (count == 30 && a > 1) {
					System.out.println("입력 할 수 있는 숫자 : 1");
					count -= a;
				}
				count += a;
				System.out.println("현재 숫자 : " + count);
			}
				else if (count == 31) {
					System.out.println("패배하셨습니다");
				break;
				}
		}
			
	}
}
