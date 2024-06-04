package oop.method04;

public class Item {

	String name;
	String type;
	int price;
	int count;
	boolean discount;
	int rate;
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
			boolean discount, boolean delivery, int rate) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.count = count;
		this.discount = discount;
		this.delivery = delivery;
		this.rate = rate;
		
	}
	
	
	void info() {
		System.out.println("<상품정보>");
		System.out.println(this.name);
		System.out.println(this.type);
		System.out.println("가격 : " + this.price + "원");
		System.out.println("개수 : " + this.count + "개");
		if(discount) {
		System.out.print(this.price * (100 - this.rate) / 100 +"원");
		System.out.println(" (원가 : " + this.price + "원)");}
		if(delivery) {
		System.out.println("새벽배송 가능");}
		else {
			System.out.println("새벽배송 불가능");
		}
	}
}
