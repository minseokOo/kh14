package random;

import java.util.Random;

public class Test02가위바위보2 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		int firstPlayer = r.nextInt(3) + 1;
		int secondPlayer = r.nextInt(3) + 1;
		
		//1p 계산
		System.out.print("1P : ");
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
		
		//2p 계산
		System.out.print("2P : ");
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
			System.out.println("2P가 이겼습니다!");
		}
		else if (secondPlayer == 3 && firstPlayer == 1) {
			System.out.println("1P가 이겼습니다!");
		}
		
		else if (firstPlayer > secondPlayer) {
			System.out.println("1P가 이겼습니다!");
		}
		else if (secondPlayer > firstPlayer) {
			System.out.println("2P가 이겼습니다!");
		}
		else {
			System.out.println("비겼습니다!");
		}
		
		
	}
}
