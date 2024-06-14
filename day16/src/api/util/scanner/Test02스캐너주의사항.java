package api.util.scanner;

import java.util.Scanner;

public class Test02스캐너주의사항 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단어 입력 : ");
		String word = sc.next(); //안녕\n
		
		sc.nextLine(); //엔터를 제거
		
		System.out.print("문장 입력 : ");
		String line = sc.nextLine(); //next() 뒤에 오면 next()에서 넘어온 \n 에 반응해서 끝남
		
		sc.close();
		
		System.out.println("입력한 단어 : " + word);
		System.out.println("입력한 문장 : " + line);
	}
}
