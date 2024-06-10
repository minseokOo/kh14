package oop.inherit08;

public class Test02스마트폰정보 {

	public static void main(String[] args) {
		
		Galaxy23FE p1 = new Galaxy23FE("갤럭시 23FE", "010-0000-0000","레드" );
		p1.show();
		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();
		System.out.println("--------------------");
		
		GalaxyFold5 p2 = new GalaxyFold5("갤럭시 폴드5", "010-0000-0001", "블루");
		p2.show();
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();
		System.out.println("--------------------");
		
		IPhone14 p3 = new IPhone14("아이폰 14", "010-0000-0002", "골드");
		p3.show();
		p3.call();
		p3.sms();
		p3.itunes();
		p3.siri();
		System.out.println("--------------------");
		
		IPhone15 p4 = new IPhone15("아이폰 15", "010-0000-0004", "실버");
		p4.show();
		p4.call();
		p4.sms();
		p4.faceTime();
		p4.siri();
		
	}
}
