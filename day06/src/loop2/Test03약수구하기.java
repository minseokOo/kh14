package loop2;

import java.util.Scanner;

public class Test03약수구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int valueCount = 0;
		
		
		
		int value = sc.nextInt();
		
		for (int i = 1; i <= 10000; i++) {
			if (value % i ==0) {
				System.out.println(value + "의 약수 : " + i);
				valueCount++;
			}
		}
		System.out.println("약수의 개수는 " + valueCount + "개");
		
		
		
	}
}
