package array;

import java.util.Scanner;

public class Test03숫자입력 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int [3];

		System.out.print("숫자 입력 : ");
		arr[0] = sc.nextInt();
		System.out.print("숫자 입력 : ");
		arr[1] = sc.nextInt();
		System.out.print("숫자 입력 : ");
		arr[2] = sc.nextInt();
		
		System.out.println("총 합계 : " + (arr[0] + arr[1] + arr[2]));
	}
}
