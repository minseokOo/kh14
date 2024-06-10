package oop.inherit08;

public abstract class Apple extends Phone {

	public Apple(String name, String numberData, String color) {
		super(name, numberData, color);
	}

	@Override
	public void call() {
		System.out.println(this.getName() + " 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println(this.getName() + " 문자 기능 실행");
	}
	public abstract void siri();

}
