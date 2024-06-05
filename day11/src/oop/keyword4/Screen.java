package oop.keyword4;

//게임화면 클래스(크기 변경 불가)
public class Screen {
	//필드에 final 이 붙으면 반드시 값을 초기화 하는 코드가 있어야 한다.
	// - 필드에 직접 작성
	// - 생성자에 작성
	private final int width; //폭
	private final int height; //높이
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
}
