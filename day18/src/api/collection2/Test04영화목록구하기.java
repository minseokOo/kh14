package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test04영화목록구하기 {
	public static void main(String[] args) {
		
		Set<String> mario = Set.of("인사이드아웃2", "하이재킹", "1초앞 1초뒤", "원더랜드", "몽키맨");
		Set<String> luize = Set.of("북극백화점의 안내원", "인사이드아웃2", "프렌치 수프", "프리실라", "원더랜드");
		
		Set<String> union = new TreeSet<>();
		union.addAll(mario);
		union.addAll(luize);
		System.out.println("모든 영화 목록 : " + union);
		
		Set<String> intersect = new TreeSet<>();
		intersect.addAll(mario);
		intersect.retainAll(luize);
		System.out.println("<둘 다 본 영화>");
		for(String name : intersect) {
		System.out.println(name);
		}
		Set<String> one = new TreeSet<>();
		one.addAll(union);
		one.removeAll(intersect);
		System.out.println("<한명만 본 영화>");
		for(String name : one) {
			System.out.println(name);
		}
	}
}
