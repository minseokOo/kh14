package oop.keyword1;

//삼각형 넓이 계산기 = 
public class Calculator {
	//필드
	private int width;
	private int height;
	
	void setWidth(int width) {
		if(width <= 0) return;
		this.width = width;
	}
	void setHeight(int height) {
		if(height <= 0) return;
		this.height = height;
	}
	
	
	int getWidth() {
		return width;
	}
	int getHeight() {
		return height;
	}
	public float getArea() {
		return this.getWidth() * this.getHeight() /2f;
	}
	
	//생성자
	public Calculator(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}
	
}
