package oop.inherit04;

public class Test01카메라기능 {

	public static void main(String[] args) {

		WebCam w1 = new WebCam();
		w1.setName("WebCam");
		w1.setPixel("800");
		w1.record();
		w1.decorate();
		System.out.println("---------------------");
		
		ActionCam a1 = new ActionCam();
		a1.setName("ActionCam");
		a1.setPixel("3000");
		a1.record();
		a1.slowMotion();
		a1.reduce();
		System.out.println("---------------------");
		
		DigitalCam d1 = new DigitalCam();
		d1.setName("DigitalCam");
		d1.setPixel("6000");
		d1.record();
		d1.wideRecord();
		d1.slowMotion();

	}

}
