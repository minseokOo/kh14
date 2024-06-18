package api.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test03집합연산 {
	public static void main(String[] args) {
		// 집합연산
		// - 저장소끼리의 계산 (List, Set, ...)
		// - 그 중에서 Set 은 중복이 제거되므로 일반적인 집합연산이 가능
		// - 합집합, 교집합, 차집합
		
		Set<Integer> a = Set.of(10, 20, 30, 40);
		Set<Integer> b = Set.of(10, 40, 50);
		
		// 합집합 - A ∪ B
		Set<Integer> union = new HashSet<>();
		union.addAll(a);
		union.addAll(b);
		System.out.println("합집합 = " + union);
		
		// 교집합 A ∩ B
		Set<Integer> intersect = new HashSet<>();
		intersect.addAll(a); //a 를 추가하고
		intersect.retainAll(b); // b 와 겹치는 것만 남겨라
		System.out.println("교집합 = " + intersect);
		
		// 차집합 - A - B
		Set<Integer> minus = new HashSet<>();
		minus.addAll(a); //a 를 추가하고
		minus.removeAll(b); // b 에 있는걸 삭제해라
		System.out.println("차집합 = " + minus);
	}
}
