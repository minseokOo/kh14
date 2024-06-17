package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07도우미클래스 {
	public static void main(String[] args) {
		//도우미 클래스
		// - 어떤 클래스에 대한 보조 기능을 제공하는 클래스
		// - 클래스 뒤에 s 가 붙음
		// - Object 에 대한 도우미 클래스는 Objects 입니다.
		// - Arrays, Collections 등이 존재
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<= 10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		//순서 뒤집기
		Collections.reverse(list);
		System.out.println(list);
		
		//순서 랜덤 섞기
		Collections.shuffle(list);
		System.out.println(list);
		
		//순서 정렬(오름차순/내림차순)
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
	}
}
