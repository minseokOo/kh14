package api.collection;

import java.util.ArrayList;

public class Test04리스트추출 {
	public static void main(String[] args) {
		//리스트의 모든 데이터는 위치(index)를 가지고 있다.
		
		ArrayList<String> data = new ArrayList<>();
		data.add("자바"); //0
		data.add("파이썬"); //1
		data.add("루비"); //2 > 3
		data.add("앨릭서"); //3 > 4
		data.add("자바스크립트"); //4 > 5
		
		//데이터를 중간에 삽입할 수 있다
		data.add(2, "고랭");  //2
		
		System.out.println("data = " + data);
		
		// (Q) 3번 위치에 있는 데이터는 무엇인가요?
		System.out.println(data.get(3));
		//System.out.println(data.get(9999)); //예외 (범위초과)
		
		// (Q) 리스트에 존재하는 모든 데이터를 순서대로 출력
		for(int i = 0; i<data.size(); i++) {
			System.out.println(data.get(i));
		}
		int o = 0;
		while(o<data.size()) {
			System.out.println(data.get(o));
			o++;
		}
		
	}
}
