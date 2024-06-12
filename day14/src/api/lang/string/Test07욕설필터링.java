package api.lang.string;

import java.util.Scanner;

public class Test07욕설필터링 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			String input = sc.nextLine();
		if(input.contains("신발끈")) {
			input = input.replace("신발끈", "***");
		}
		else if (input.contains("시방")) {
			input = input.replace("시방", "**");
		}
		else if (input.contains("개나리")) {
			input = input.replace("개나리", "***");
		}
		else if (input.contains("십장생")) {
			input = input.replace("십장생", "***");
		}
		else if (input.contains("시베리아")) {
			input = input.replace("시베리아", "****");
		}
		else if (input.contains("수박씨")) {
			input = input.replace("수박씨", "***");
		}
		else if (input.contains("주옥")) {
			input = input.replace("주옥", "**");
		}
		else if (input.contains("개새")) {
			input = input.replace("개새", "**");
		}
		else if (input.contains("된장")) {
			input = input.replace("된장", "**");
		}
		else if (input.contains("쌍쌍바")) {
			input = input.replace("쌍쌍바", "***");
		}
		
		
		System.out.println(input);
		}
				
		
		
		
		
	}
}
