package api.util.scanner;

import java.util.Scanner;

public class Test03패턴분석 {
	public static void main(String[] args) {

		// 객체 생성
		String song = "빨강+주황-노랑=초록/파랑*남색%보라";
		Scanner sc = new Scanner(song);

		sc.useDelimiter("[+-=/*%\\s\\d]");
		//\\s = 스페이스바
		//\\d = 0-9
		//\\w = 글자
		
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}

		sc.close();
	}
}
