package oop.inherit08;

public class Galaxy23FE extends Samsung {

	public Galaxy23FE(String name, String numberData, String color) {
		super(name, numberData, color);
	}

	@Override
	public void samsungPay() {
		System.out.println(this.getName() + " 삼성페이 기능 실행");
	}

	public void bixby() {
		System.out.println(this.getName() + " 음성인식 기능  실행");
	}

}
