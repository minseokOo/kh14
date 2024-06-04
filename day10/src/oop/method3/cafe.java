package oop.method3;

public class cafe {
	String menu;
	String type;
	int price;
	String event;
	
	void setting(String menu, String type, int price, String event) {
		this.menu = menu;
		this.type = type;
		this.price = price;
		this.event = event;
	}
	
	void info() {
		System.out.println(this.menu);
		System.out.println(this.type);
		System.out.println(this.price);
		System.out.println(this.event);
	}
}
