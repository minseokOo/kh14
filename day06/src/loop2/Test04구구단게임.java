package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test04구구단게임 {

	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int failCount = 0;
		
		for(int i = 0; i < 10; i++) {
		
		int gugu = r.nextInt(8) + 2;
		int gugu2 = r.nextInt(8) + 2;
		int question = gugu * gugu2;
		System.out.print(gugu +" * " + gugu2 + " = ");
		int answer = sc.nextInt();
		
		if(answer == question) {
			System.out.println("정답입니다.");
			count++;
		}
		else {
			System.out.println("틀렸습니다.");
			failCount++;
		}
		}
		System.out.println("맞은 개수 : " + count + "개");
		System.out.println("틀린 개수 : " + failCount + "개");
		
	}
}
