package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01세트저장소 {
	public static void main(String[] args) {
		// Map
		// - 개별 데이터 특화 저장소
		// 돌잔치 추첨 프로그램
		
		Map<Integer, String> data = new HashMap<>();
		
		//data.add(?); //데이터를 1개 추가하는 메소드
		data.put(1, "마이크");
		data.put(2, "청진기");
		data.put(3, "마이크");//value 는 중복이 가능하다
		data.put(4, "돈");
		data.put(5, "돈");
		
		data.put(1, "돈"); //key 가 겹치면 기존 value 가 수정된다
		
		
		System.out.println(data);
		System.out.println(data.size());
		
		// 검색
		System.out.println(data.containsKey(7));
		System.out.println(data.containsValue("마이크"));
		
		//삭제
		data.remove(4);
		System.out.println(data);
		System.out.println(data.size());
		
		//추출
		System.out.println(data.get(2));//2번 값을 추출
		System.out.println(data.get(99));
		
	}
}
