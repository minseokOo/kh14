package oop.inherit08;

public class IPhone15 extends Apple {

	public IPhone15(String name, String numberData, String color) {
		super(name, numberData, color);
	}
	public void faceTime() {
		System.out.println(this.getName() + " 영상통화 기능 실행");
	}
	
	@Override
	public void siri() {
		System.out.println(this.getName() + " 음성 인식 기능 실행");
	}

	
}
