package oop.inherit05;

// 상속에서 사용 할 수 있는 여러가지 기술들(or 주의사항)
// 상위 클래스도 클래스이기 때문에 필드, 메소드, 생성자가 존재한다.
// - 필드 : 접근제한을 강화(private) 또는 완화(protected)
// - 생성자 : 상속받는 클래스(하위클래스)에서 반드시 해당 생성자를 이용해야함
public class Phone {
	// 전화번호
	// private String number;//상속이고 뭐고 무조건 외부에서 접근 금지(절대불변)
	protected String number;// 상속 관계일 땐 자유롭게 접근가능(개조가능)

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	
//	번호를 반드시 설정하는 생성자
	public Phone(String number) {
		this.setNumber(number);
	}
}
