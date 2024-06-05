package oop.keyword2;

//삼각형 넓이 계산기 = 
public class Calculator {
	//static 키워드를 붙이면 객체 생성 없이 접근이 가능
	public static float getArea(int width, int height) {
		//this 뿐 아니라 객체 지향의 모든 개념을 사용 불가
		return width * height /2f;
	}
	public static int rect(int width, int height) {
		return width * height;
	}
	
}
