package loop4;

import java.util.Scanner;

public class Test03합계평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = 0;
		int count = 0;

		while (true) {
			System.out.print("숫자 입력 : ");
			int a = sc.nextInt();

			if (a == 0) {
				break;
			}
				total += a;
				count++;
				
		}
		float average = (float) total / (count);
		System.out.println("여태까지 입력한 숫자의 합계 : " + total);
		System.out.println("여태까지 입력한 숫자의 평균 : " + average);
	}
}
