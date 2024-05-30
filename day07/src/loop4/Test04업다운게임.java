package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test04업다운게임 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int question = r.nextInt(1000)+1;
		int count = 0;
		
		
		while (true) {
			System.out.print("숫자 입력 : ");
			int answer = sc.nextInt();
			if (question > answer) {
				System.out.println("업!");
				count++;
			}
			if (question < answer) {
				System.out.println("다운!");
				count++;
			}
			if (question == answer) {
				System.out.println("정답");
				count++;
				break;
			}
			
			
		}
		System.out.println(count + "번째에 맞추셨습니다.");
		
		
	}
}
