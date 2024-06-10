package oop.inherit01;

public class Test01상속의필요성 {

	public static void main(String[] args) {
		IPhone15 p1 = new IPhone15();
		p1.call();
		p1.internet();
		p1.camera();
		p1.applePay();
		System.out.println("---------------------");
		
		Galaxy23s p2 = new Galaxy23s();
		p2.call();
		p2.internet();
		p2.camera();
		p2.samsungPay();
		
	}
}
