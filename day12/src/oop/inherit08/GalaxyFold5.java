package oop.inherit08;

public class GalaxyFold5 extends Samsung {

	public GalaxyFold5(String name, String numberData, String color) {
		super(name, numberData, color);
	}

	@Override
	public void samsungPay() {
		System.out.println(this.getName() + " 삼성페이 기능 실행");
	}
	public void iris() {
		System.out.println(this.getName() + " 홍채인식 기능 실행");
	}

}
