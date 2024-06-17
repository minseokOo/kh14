package api.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test03로또번호추첨기 {
	public static void main(String[] args) {
		
		Random r = new Random();
		ArrayList<Integer> a = new ArrayList<>(6);
		
		for(int i=0; i<6; i++) {
		if(a.contains(a)){ // 이미 존재하는 번호라면
			i--;
		}
		else { //존재하지 않는 번호라면
		a.add(r.nextInt(45)+1);
		
		}
		}
		System.out.println("로또번호 = " + a);
	}
}
