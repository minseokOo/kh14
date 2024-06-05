package oop.modifier1;

public class Student {
	// 필드는 외부에서 직접 접근하면 제어가 어렵다(원치 않는 사용이 가능)
	// 잠금 키워드인 private 을 사용하여 접근을 차단한다.
//  private - 클래스 외부의 접근을 차단(보호 목적, 비공개)
//	package - 키워드를 안붙이면 기본 설정되는 범위(같은 패키지)
//	protected - 패키지접근 + 상속관계접근 허용
//	public - 모든 접근을 허용(공개)
	
	private String name;
	private int score;
	
	//메소드는 외부 호출이 가능해야 한다.
	//다른 패키지에서 사용해야 할 경우 public 키워드를 사용
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score < 0 || score > 100) return;
		this.score = score;
	}
	
	public void setting(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	public void info() {
		System.out.println("이름 = " + this.getName());
		System.out.println("점수 = " + this.getScore());
	}
}
