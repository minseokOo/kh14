package oop.poly01_2;

public class GalaxyBook extends NoteBook {

	@Override
	public void power() {
		System.out.println("갤럭시북 전원 누름");
	}

	@Override
	public void video() {
		System.out.println("갤럭시북 비디오 기능 실행");
	}

	@Override
	public void typing() {
		System.out.println("갤럭시북 타이핑 기능 실행");
	}
}
