package oop.inherit04;

public class Camera {

	private String name;
	private String pixel;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPixel(String pixel) {
		this.pixel = pixel;
	}
	public String getPixel() {
		return pixel;
	}
	
	public void record() {
		System.out.println("동영상 녹화 기능");
	}
}
