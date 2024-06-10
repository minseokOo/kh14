package oop.inherit04;

//클래스에 final 을 추가하면 이 클래스는 상속불가
public class ActionCam extends Camera {

	public void slowMotion() {
		System.out.println("슬로우 모션 촬영 기능");
	}
	public void reduce() {
		System.out.println("흔들림 보정 기능 실행");
	}
}
