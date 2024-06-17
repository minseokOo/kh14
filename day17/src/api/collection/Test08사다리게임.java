package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08사다리게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수를 입력하세요 : ");
		int a = sc.nextInt();
		sc.nextLine();
		
		List<String>input = new ArrayList<>();
		for(int i=1; i<= a; i++) {
			System.out.print(i + "번 이름을 입력하세요 : ");
			input.add(sc.next());
		}
		//System.out.println(input);
		List<String>output = new ArrayList<>();
		for(int i=1; i<= a; i++) {
			System.out.print(i + "번 당첨 항목을 입력하세요 : ");
			output.add(sc.next());
		}
		sc.close();
		//System.out.println(output);
		Collections.shuffle(output);
		for(int i=0; i<a; i++) {
		System.out.println(input.get(i) + " --------> " + output.get(i));
		
		}
		}
}
