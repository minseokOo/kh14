package api.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test01순서가정해진저장소 {
	public static void main(String[] args) {
		// Set<E>
		// - 순서가 정해진 저장소
		// - TreeSet, HashSet, ...
		// - 인덱스(순서)가 존재할 수 없는 비선형 구조
		// - (중요) 데이터를 낱개로 관리하지 않고 전체로 관리하는 형태(검색 특화)
		// - 중복 데이터 저장 불가능
		
		//Set<String> data = new TreeSet<>(); //트리구조
		Set<String> data = new HashSet<>(); //해시구조
		
		data.add("피카츄");
		data.add("라이츄");
		data.add("파이리");
		data.add("꼬부기");
		data.add("버터플");
		
		data.add("꼬부기"); //추가 안됨
		
		System.out.println(data);
		System.out.println(data.size());
		System.out.println(data.contains("라이츄"));
		
		data.remove("꼬부기");
		System.out.println(data);
		System.out.println(data.size());
		
	}
}
