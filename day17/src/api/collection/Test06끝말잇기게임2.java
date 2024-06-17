package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> history = new ArrayList<>();
		history.add("자바");
		while(true) {
		String word = history.get(history.size()-1);
		System.out.println("제시어 : " + word);
		
		System.out.print("입력 : ");
		String input = sc.nextLine();
		
		if(!input.matches("^[가-힣]{2,6}$")) {
			break;
		}
		char last = word.charAt(word.length()-1);
		char first = input.charAt(0);
		if(last != first) {
			break;
		}
		
		history.add(input);
		
		}
		
		sc.close();
		
		System.out.println("게임 오버!");
		
		System.out.println("<입력기록>");
		for(int i=0; i < history.size(); i++) {
			String word = history.get(i);
			System.out.println("->" + word);
			
		}
	}
}
