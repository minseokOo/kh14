package oop.inherit07;

//절대로 바뀌면 안되는 메소드(final) vs 무조건 바꿔야 되는 메소드
public abstract class Galaxy {
	
//	public final void serial() {
//		System.out.println("초기화 번호 ooo-ooo-oooo 입니다");
//	}
	public void serial() {
		System.out.println("초기화 번호 ooo-ooo-oooo 입니다");
	}
	
	//요구사항 : 삼성페이는 버전별로 모두 다르게 작동해야한다
	public abstract void samsungPay();
		
	
}
