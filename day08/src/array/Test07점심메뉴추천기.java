package array;

import java.util.Random;
import java.util.Scanner;

public class Test07점심메뉴추천기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		String foodCounts[] = new String[5];
		int random = r.nextInt(foodCounts.length)+1;
		
		for (int i = 0; i < foodCounts.length; i++) {
			System.out.print("입력 : ");
			foodCounts[i] = sc.next();
		}
		System.out.println("오늘은 " + foodCounts[random] + "을(를) 드시죠!");
	}
}
