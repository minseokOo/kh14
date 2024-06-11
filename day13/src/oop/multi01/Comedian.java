package oop.multi01;

//인터페이스(interface)
// - 다중상속 전용 클래스
// - 다중상속에 문제가 되는 필드, 메소드, 생성자가 모두 제거된 형태
public interface Comedian {
	//필드
	// - 상수를 제외하고 생성 불가 public static final
	//private int a; 변수 생성 불가
	/*public static final*/ int a = 10; //상수일경우 생성 가능
	
	//메소드
	// - 추상메소드 생성 가능
	// - 일반 메소드는 생성 불가(단, default 메소드는 가능)
	/*public abstract*/ void comment(); //추상 메소드
//	public void comment() { 일반 메소드 생성 불가
//	}
		
	//생성자
	// - 절대 생성 불가
	//public Comedian() {}
	
}
