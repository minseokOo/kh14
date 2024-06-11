package oop.poly02;

public class Test01업캐스팅 { //업캐스팅 : 서로 다른 데이터들을 통합할때 사용
	public static void main(String[] args) {
		
		//상자를 만들어서 카메라를 보관하는 코드를 작성
		
		Box box = new Box();
		
		DigitalCamera camera = new DigitalCamera();
		
		box.setCamera(camera); //디지털 카메라가 카메라 하위개념이라서 가능
		
		
	}
}
