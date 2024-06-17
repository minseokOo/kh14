package api.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test09기타명령들 {
	public static void main(String[] args) {
		//리스트 생성 방법
		// - 가변 리스트와 불변 리스트
		List<String> a = new ArrayList<>(); //가변
		List<String> b = new LinkedList<>(); //가변
		
		//불변 (Java 8+)
		List<String> c = Arrays.asList("피카츄", "라이츄", "파이리"); //불변
		//불변 (Java 9+)
		List<String> d = List.of("피카츄", "라이츄", "파이리"); //불변
		Collections.shuffle(c);
		System.out.println("c = " + c); 
		System.out.println("d = " + d);
		
		//리스트 자르기
		List<String> e = d.subList(0, 2);//0부터 2전까지
		System.out.println("e = " + e);
		
		//(ex) 로또 번호 생성기
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i<=45; i++) {
			numbers.add(i);
		} 
		Collections.shuffle(numbers);
		List<Integer> lottoNumbers = numbers.subList(0, 6);
		Collections.sort(lottoNumbers);
		System.out.println(lottoNumbers);
	}
}
