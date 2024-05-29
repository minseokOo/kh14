package loop2;

import java.util.Scanner;

public class Test03약수구하기2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int valueCount = 0;
		
		
		
		int value = sc.nextInt();
		
		System.out.print(value + "의 약수 : ");
		for (int i = 1; i <= value; i++) {
			if (value % i ==0) {
				System.out.print(i + "  ");
				valueCount++;
			}
		}
		System.out.println();
		System.out.println("약수의 개수는 " + valueCount + "개");
		
		if (valueCount == 2) {
			System.out.println(value + "는 소수입니다.");
		}
		
		
	}
}
