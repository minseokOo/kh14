package api.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Test05기억력테스트게임 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<>();
		
		
		while(true) {
			System.out.print("편의점에 가면 : ");
			String item = sc.nextLine();
			
			item = item.replace(" ", "");
			
			if(!a.contains(item)) {
				a.add(item);
			}
			else if (a.contains(item)) {
				System.out.println("게임오버!");
				System.out.println("최종 점수 : " + a.size());
				break;
			}
		}
		
		sc.close();
		
	}
}
