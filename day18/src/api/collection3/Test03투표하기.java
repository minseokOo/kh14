package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03투표하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> name = new TreeMap<>();
		String input;
		
		while(true) {
			input = sc.nextLine();
			
			if(input.equals("종료")) {
				System.out.println("종료합니다.");
				sc.close();
				break;
			}
			else if(name.containsKey(input)) {
				name.put(input, name.get(input) +1);
				System.out.println("[" + input + "] 현재 " + name.get(input) + "표 획득");
			}
			else {
				name.put(input, 1);
				System.out.println("[" + input + "] 현재 " + name.get(input) + "표 획득");
			}
			}
		for(String key : name.keySet()) {
			System.out.println(key + ": " + name.get(key) + "표");
		}
		
		
	}
}
