package oop.test1;

public class Test01메세지생성 {

	public static void main(String[] args) {

		//메세지 생성
		Message a = new Message();

		a.sender = "라이언";
		a.text = "오늘 언제와";
		a.time = "오후 12:29";
		a.count = 1;
		
		System.out.println(a);
		System.out.println(a.sender);
		System.out.println(a.text);
		System.out.println(a.time);
		System.out.println(a.count);
		
		//메세지 하나 더 생성
		Message b = new Message();
		System.out.println(b);
		System.out.println(b.sender);
		System.out.println(b.text);
		System.out.println(b.time);
		System.out.println(b.count);
	
	}

}
