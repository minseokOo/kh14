package condition;

import java.util.Scanner;

public class Test02출석검사기 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("출석시간(시)을 입력하세요");
		int entryTime = sc.nextInt();
		System.out.println("출석시간(분)을 입력하세요");
		int entryMinute = sc.nextInt();
		int startTime = 9;
		int startMinute = 30;
		
		int entry = entryTime * 60 + entryMinute;
		int start = startTime * 60 + startMinute;
		
		boolean a = entry <= start;
		
		if(a) {
			System.out.println("정상출석입니다.");
		}
		
		else {
			System.out.println("지각입니다.");
		}
	}

}
