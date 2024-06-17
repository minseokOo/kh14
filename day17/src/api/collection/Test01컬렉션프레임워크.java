package api.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01컬렉션프레임워크 {
	public static void main(String[] args) {
		//컬렉션(Collection)
		// - 데이터를 무한대로 저장할 수 있는 저장소
		
		//TreeSet a = new TreeSet();
		TreeSet<String> a = new TreeSet<String>();
		a.add("피카츄");
		a.add("라이츄");
		a.add("파이리");
		a.add("꼬부기");
		System.out.println("a = " + a);
		
		ArrayList<String> b = new ArrayList<String>();
		b.add("피카츄");
		b.add("라이츄");
		b.add("파이리");
		b.add("꼬부기");
		System.out.println("b = " + b);
	}
}
