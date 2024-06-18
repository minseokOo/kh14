package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test04맵전체출력 {
	public static void main(String[] args) {
		Map<String, Integer> people = new HashMap<>();
		people.put("장원영", 2004);
		people.put("안유진", 2003);
		people.put("지성", 2002);
		people.put("김하온", 2000);
		people.put("아린", 1999);
		
		//people 의 모든 데이터를 출력하세요
		// - 직접 출력 가능한 방법은 없다
		// [1] Map 의 key 는 Set 과 같기 때문에 Set 으로 옮겨서 조회
		// [2] key=value 를 Entry 라는 형태로 묶어서 조회
		
		// [1]
		Set<String> keys = people.keySet(); //key 를 Set 으로 추출
		for(String name : keys) {
			System.out.println("name = " + name + ", birth : " + people.get(name));
		}
		
		System.out.println();
		
		//[2]
		//Set<Map.Entry<String, Integer>> entries = people.entrySet();
		for(Map.Entry<String, Integer> entry : people.entrySet()) {
			System.out.println("name = " + entry.getKey() + ", birth = " +entry.getValue());
			
		}
		
	}
}
