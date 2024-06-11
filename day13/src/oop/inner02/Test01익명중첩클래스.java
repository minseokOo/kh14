package oop.inner02;

public class Test01익명중첩클래스 {
	public static void main(String[] args) {
		//추상 클래스나 인터페이스는 객체 생성이 안된다.
		//Button button = new Button();
		
		//그래도 만들고 싶다면 1. 상속받은 클래스를 만들거나 2. 일회용 상속을 만든다
		
		Button menu = new Button() {
			@Override
			public void push() {
				System.out.println("메뉴 실행!");
			}
		};
		
		menu.push();
	}
}
