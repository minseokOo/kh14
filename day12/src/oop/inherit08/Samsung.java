package oop.inherit08;

public abstract class Samsung extends Phone {

	public Samsung(String name, String numberData, String color) {
		super(name, numberData, color);

	}

	@Override
	public void call() {
		System.out.println(this.getName() + " 전화기능 실행");
	}

	@Override
	public void sms() {
		System.out.println(this.getName() + " 문자기능 실행");
	}

	public abstract void samsungPay();
}
