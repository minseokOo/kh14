package oop.method01;

//상품 클래스
public class Item {
	//멤버 필드
	// - 모든 객체가 공통적으로 사용하는 '데이터'를 담아두는 도구
	String name;
	String type;
	int price;
	
	//멤버 메소드
	// - 모든 객체가 공통적으로 사용하는 '코드'를 담아두는 도구
	// - void 이름(준비물) {코드} //메소드의 형태
	void setting(String name, String type, int price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	
	void info() {
		System.out.println(this.name);
		System.out.println(this.type);
		System.out.println(this.price + "원");
	}
}
