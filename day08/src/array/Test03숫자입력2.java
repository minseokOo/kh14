package array;

import java.util.Scanner;

public class Test03숫자입력2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int size = 5;
		
		int arr[] = new int [size];
		for(int i = 0; i < size ; i++) {
		System.out.print("숫자 입력 : ");
		arr[i] = sc.nextInt();
		total += arr[i];
		}
		for(int i =0; i<size; i++) {
			System.out.println("data["+i+"] = " + arr[i]);
		}
		System.out.println("총 합계 : " + total);
	}
}
