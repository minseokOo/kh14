package array;

import java.util.Scanner;

public class Test04짝수출력 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;
		int number[] = new int[5];

		for (int i = 0; i < number.length; i++) {
			System.out.print("숫자 입력 : ");
			number[i] = sc.nextInt();
		}
		
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				count++;
				System.out.println("짝수 숫자 : " + number[i]);
			}
		}
		
		System.out.println("총 짝수의 수 : " + count + "개");
	}
}
