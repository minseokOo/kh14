package oop.method04;

public class Item {

	String name;
	String type;
	int price;
	int count;
	boolean discount;
	boolean delivery;
	
	void setting (String name, String type, int price, int count,
			boolean delivery) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.count = count;
		this.discount = false;
		this.delivery = delivery;
		
	}
	void setting (String name, String type, int price, int count,
			boolean discount, boolean delivery) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.count = count;
		this.discount = discount;
		this.delivery = delivery;
		
	}
	
	
	void info() {
		System.out.println(this.name);
		System.out.println(this.type);
		System.out.println(this.price);
		System.out.println(this.count);
		System.out.println(this.discount);
		System.out.println(this.delivery);
	}
}
