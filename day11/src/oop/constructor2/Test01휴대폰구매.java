package oop.constructor2;

public class Test01휴대폰구매 {

	public static void main(String[] args) {
		
		Phone p1 = new Phone("갤럭시Fold4", "SK", 180, 0);
		Phone p2 = new Phone("갤럭시Fold4", "KT", 175, 24);
		Phone p3 = new Phone("아이폰15", "LG", 200, 30);
		Phone p4 = new Phone("아이폰15", "SK", 199, 0);
		
		p1.info();
		p2.info();
		p3.info();
		p4.info();
	}
}
