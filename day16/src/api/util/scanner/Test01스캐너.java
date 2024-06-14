package api.util.scanner;

import java.util.Scanner;

public class Test01스캐너 {
	public static void main(String[] args) {
		
		//객체 생성
		String song = "노는게 제일좋아 친구들 모여라\n"
				+ " 언제나 즐거워 뽀롱뽀롱뽀롱뽀롱 뽀로로";
		Scanner sc = new Scanner(song);
		
		//sc.hasNext() - 읽을 단어가 있는지 확인하는 명령
		//sc.next() - 한 단어 읽기(공백 기준)
		
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		System.out.println(sc.hasNext());
		System.out.println(sc.next());
		
		
	}
}
