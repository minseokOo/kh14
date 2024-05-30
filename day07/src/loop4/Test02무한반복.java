package loop4;

import java.util.Random;

public class Test02무한반복 {

	public static void main(String[] args) {
		
		Random r = new Random();
		while(true) {
			int dice = r.nextInt(6) + 1;
			System.out.println("주사위 : " + dice);
			if(dice==6) {
				break;
			}
		}
		
	}
}
