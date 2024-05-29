package random;

import java.util.Random;
import java.util.Scanner;

public class Test02가위바위보3 {

	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int firstPlayer = r.nextInt(3) + 1;
		
		//computer 계산
		System.out.print("Computer : ");
		switch (firstPlayer) {
		
		case 1 :
			System.out.println("가위");
		break;
		case 2 :
			System.out.println("바위");
		break;
		case 3 :
			System.out.println("보");
		break;
		}
		
		//Player 계산
		
		System.out.print("Player(1.가위 2.바위 3.보) : ");
		int secondPlayer = sc.nextInt();
		
		System.out.print("Player : ");
		switch (secondPlayer) {
		
		case 1 : 
			System.out.println("가위");
		break;
		case 2 :
			System.out.println("바위");
		break;
		case 3 :
			System.out.println("보");
		break;
		}
		
		//결과
		if (firstPlayer == 3 && secondPlayer == 1) {
			System.out.println("Player가 이겼습니다!");
		}
		else if (secondPlayer == 3 && firstPlayer == 1) {
			System.out.println("Computer가 이겼습니다!");
		}
		
		else if (firstPlayer > secondPlayer) {
			System.out.println("Computer가 이겼습니다!");
		}
		else if (secondPlayer > firstPlayer) {
			System.out.println("Player가 이겼습니다!");
		}
		else {
			System.out.println("비겼습니다!");
		}
		
		
	}
}
