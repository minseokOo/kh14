package oop.method01;

public class Test01메소드활용 {

	public static void main(String[] args) {
		Item a = new Item();
		Item b = new Item();
		
		//a를 주인공(this)으로 해서 setting 메소드의 코드를 실행 시키는데
		//필요한 준비물 자리에 "참이슬", "주류", 1100을 순서대로 넣어라!
		a.setting("참이슬", "주류", 1100);
		b.setting("코카콜라", "음료", 2000);
		
		a.info();//a를 주인공(this)으로 해서 info 메소드의 코드를 실행시켜라
		b.info();//b를 주인공(this)으로 해서 info 메소드의 코드를 실행시켜라
	
	}
}
