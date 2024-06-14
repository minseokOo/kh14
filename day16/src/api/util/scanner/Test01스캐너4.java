package api.util.scanner;

import java.util.Scanner;

public class Test01스캐너4 {
	public static void main(String[] args) {
		
		//객체 생성
		String song = "노는게 제일좋아 친구들 모여라\n"
				+ " 언제나 즐거워 뽀롱뽀롱뽀롱뽀롱 뽀로로";
		Scanner sc = new Scanner(song);
		
		//sc.hasNextLine() - 읽을 줄이 있는지 확인하는 명령
		//sc.nextLine() - 한 줄 읽기 (\n 기준)
		
		while(sc.hasNextLine()) {
		System.out.println(sc.nextLine());
		}
		
	}
}
