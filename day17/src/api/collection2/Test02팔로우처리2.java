package api.collection2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test02팔로우처리2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<String> data = new TreeSet<>();
		String exit = "종료";

		while (true) {
			System.out.print("닉네임 입력 : ");
			String id = sc.nextLine();
			if (id.equals(exit)) {
				System.out.println("프로그램을 종료합니다");
				sc.close();
//				System.out.println("팔로우 목록 : " + data);
				System.out.println("총 팔로우 수 : " + data.size() + "명");
				break;
			} else if (!data.contains(id)) {
				data.add(id);
				System.out.println(id + "를 팔로우 했습니다.");
			} else if (data.contains(id)) {
				data.remove(id);
				System.out.println(id + "를 팔로우 해제했습니다.");
			}

		}
		
		// 팔로우 리스트 출력(=저장소에 있는 값 출력)
		// 1. 확장 FOR 사용
		System.out.println("<팔로우 목록>");
		for(String id : data) {
			System.out.println("ID : " + id);
		}
		// 2. Iterator 사용
		Iterator<String>iterator = data.iterator();
		while(iterator.hasNext()) {
			System.out.println("ID : " + iterator.next());
		}
	}
}
