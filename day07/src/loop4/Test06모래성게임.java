package loop4;

import java.util.Scanner;

public class Test06모래성게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int total = 100;
		System.out.println("현재 남은 숫자 : " + total);
		
		while(true) {
			System.out.print("숫자 입력(1~9) : ");
			int a = sc.nextInt();
			if(a>9 || a<1) {
				System.out.println("1~9 사이의 수를 입력하세요.");
				total += a;
			}
			if((total-a)<=0) {
				System.out.println("패배하셨습니다.");
				break;
			}
			total -= a;
			System.out.println("현재 남은 숫자 : " + total);

			
			
		}
		
		
	}

}
