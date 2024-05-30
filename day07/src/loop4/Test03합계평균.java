package loop4;

import java.util.Scanner;

public class Test03합계평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int a = sc.nextInt();
			total += a;
			
			if(a == 0) {
				break;
			}
			
		}
		int average = total /3;
		System.out.println("여태까지 입력한 숫자의 합계 : " + total);
		System.out.println("여태까지 입력한 숫자의 평균 : " + average);
	}
}
