package oop.inherit07;

public class GalaxyFold4 extends Galaxy {

//	메소드 재정의(method override)
//	- 상속받은 메소드의 내용을 수정
//	- 동일한 형태로 만들어야 수정되는 효과가 생김
//	- final 을 붙인 메소드는 재정의가 불가능함
	@Override
	public void serial() {
		System.out.println("초기화 번호 xxx-xxx-xxxx 입니다");
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시 폴드4의 삼성페이");
	}
}
