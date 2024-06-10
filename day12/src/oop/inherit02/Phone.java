package oop.inherit02;

public class Phone {

	// 전화기의 공통 내용을 보관하는 클래스
	// 부모 클래스, 상위 클래스, 슈퍼 클래스 등으로 불림
	public void call() {
		System.out.println("전화기능 실행");
	}
	// 인터넷 기능
	public void internet() {
		System.out.println("인터넷 실행");
	}
	// 카메라 기능
	public void camera() {
		System.out.println("카메라 실행");
	}
}
