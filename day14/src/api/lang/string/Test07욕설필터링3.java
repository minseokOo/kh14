package api.lang.string;

import java.util.Scanner;

public class Test07욕설필터링3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] filter = new String[] {
			"신발끈", "시방", "개나리", "십장생", "시베리아", "수박씨", "주옥", "개새",
			 "된장", "쌍쌍바"
		};
		
		String[] stars = new String[] {
				"",
				"*",
				"**",
				"***",
				"****",
				"*****",
				"******",
				"*******",
				"********"
				
		};
		
		for(int i =0; i<filter.length; i++) {
			//Java 11 미만에서 가능한 방법
			String star = stars[filter[i].length()];
			input = input.replace(filter[i], star);
		}
		System.out.println(input);
		
				
		
		
		
		
	}
}
