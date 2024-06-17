package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String start = "자바";
		String korean = "^[가-힣]{2,6}$";
		List<String> history = new ArrayList<>();
		while(true) {
			System.out.println("이전 단어 : " + start );
			String word = sc.next();
			String last = start.substring(start.length() - 1);
			String first = word.substring(0);
			if (!history.contains(word) && last.equals(first) &&word.contains(korean)) {
			history.add(word);
			start = word;
			}
			
//			else {
//			break;	
//			}
		}
	}
}
