package oop.inherit08;

public class IPhone14 extends Apple {

	public IPhone14(String name, String numberData, String color) {
		super(name, numberData, color);
	}

	public void itunes() {
		System.out.println(this.getName() + " 아이튠즈 기능 실행");
	}
	
	@Override
	public void siri() {
		System.out.println(this.getName() + " 음성 인식 기능 실행");
	}

	
}
