package api.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test02팔로우처리 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<String> data = new TreeSet<>();
		String exit = "종료";

		while (true) {
			System.out.print("닉네임 입력 : ");
			String id = sc.next();
			if (id.equals(exit)) {
				System.out.println("프로그램을 종료합니다");
				sc.close();
				System.out.println("팔로우 목록 : " + data);
				break;
			} else if (!data.contains(id)) {
				data.add(id);
				System.out.println(id + "를 팔로우 했습니다.");
			} else if (data.contains(id)) {
				data.remove(id);
				System.out.println(id + "를 팔로우 해제했습니다.");
			}

		}
	}
}
