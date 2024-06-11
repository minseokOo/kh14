package oop.poly02;

//카메라를 담을 상자 객체
public class Box {
	//필드
	private Camera camera;
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public Camera getCamera() {
		return this.camera;
	}
}
