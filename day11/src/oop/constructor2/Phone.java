package oop.constructor2;

public class Phone {

	private String name;
	private String brodcast;
	private int price;
	private int agreement;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrodcast() {
		return brodcast;
	}

	public void setBrodcast(String brodcast) {
		this.brodcast = brodcast;
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) return;
		this.price = price;
	}


	public void setAgreement(int agreement) {
		if (agreement != 0 || agreement != 24 || agreement != 30) {
			return;}
		else {
			this.agreement = agreement;
		}
	}
	public int getAgreement() {
		return agreement;
	}
	public Phone(String name, String brodcast, int price) {
		this(name, brodcast, price, 0);
	}
	public Phone(String name, String brodcast, int price, int agreement) {
		this.setName(name);
		this.setBrodcast(brodcast);
		this.setPrice(price);
		this.setAgreement(agreement);
	}

	public float getMonthly() {
		return ((float)this.getPrice() / this.getAgreement());
	}

	public int getNoAgreement() {
		return (this.getPrice() * 95 / 100);
	}

	public void info() {
		System.out.println("제품명 : " + this.name);
		System.out.println("통신사 : " + this.brodcast);
		if (this.getAgreement() > 0) {
			System.out.print("가격 : " + this.price + "만원 ");
			System.out.println("(월 할부금 : " + this.getMonthly() + "만원)");
			System.out.println("약정 개월 : " + this.getAgreement() + "개월");
		} 
		else {
			System.out.print("가격 : " + this.getNoAgreement() + "만원 (원가 : " + this.price + "만원) ");
			System.out.println("(약정없음)");
		}

	}
}
