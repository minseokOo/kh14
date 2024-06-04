package oop.method3;

public class cafe {
	String menu;
	String type;
	int price;
	boolean event;
	
	//메소드 오버로딩
	// - 같은 이름으로 메소드를 다양하게 준비해두는것
	// - 메소드가 구분이 되어야 가능하다(형태가 달라야함)
	void setting(String menu, String type, int price) {
		this.menu = menu;
		this.type = type;
		this.price = price;
		this.event = false;
	}
	
	void setting(String menu, String type, int price, boolean event) {
		this.menu = menu;
		this.type = type;
		this.price = price;
		this.event = event;
	}
	
	void info() {
		if(this.event) {
		System.out.println(this.menu + "(행사중)");}
		else {
		System.out.println(this.type);}
		if(this.event) {
		System.out.println(this.price * 80 / 100);}
		else {
		System.out.println(this.price);}
		//System.out.println(this.event);
	}
}
