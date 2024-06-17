package api.collection;

import java.util.ArrayList;

public class Test02리스트 {
	public static void main(String[] args) {
		// 리스트 (List)
		// - 순서를 중요시 하는 저장소
		// - 이 그룹의 최상위 클래스는 List<E>
		
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList(10);
		ArrayList<String> c = new ArrayList<>();
		ArrayList<String> d = new ArrayList<>(10000);
		
		// - Generic Type 은 참조형만 가능하다
		ArrayList<Integer> e = new ArrayList<>();
		e.add(30);
		e.add(50);
		e.add(20);
		e.add(10);
		e.add(40); // = int[] e = new int[] {30, 50, 20, 10, 40};
		
		System.out.println("e = " + e);
		
		// (Q) e 에 들어있는 데이터 개수는?
		System.out.println("개수 = " + e.size());
		
		// (Q) e 에 20이 들어있습니까?
		System.out.println("20이 있나요?" + e.contains(20));
		
		// (Q) e 에서 10을 삭제하세요
		Integer value = 20;
		e.remove(value);
		System.out.println("e = " + e);
		System.out.println("개수 = " + e.size());
		
	}
}
