package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test05배스킨라빈스2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int count = 0;

		System.out.println("현재 숫자 : " + count);
		for(int i=0; i<31; i++) {
			int a = sc.nextInt();
			count+=a;
			System.out.println("현재 숫자 : " + count);
			
			
		}
	

	}
}
