package api.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Test05기억력테스트게임2 {

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
		//반복문을 간소화하여 처리할 수 있다(배열포함)
		// - 중간 index 과정을 생략하고 최종적으로 값이 담길 변수만 지정
		// - 일부분만 조회하거나 index 를 사용하는 계산이 어려움
		// - 확장 for 구문 (or For Each 구문)
		for(String word : a) {
			System.out.println("-> " + word);
		}
		
		sc.close();
		
	}
}
