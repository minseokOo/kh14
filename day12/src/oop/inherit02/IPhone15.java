package oop.inherit02;

// Phone 클래스에 작성한 내용을 가져와서(상속받아) 이어서 구현
// - extends 키워드를 이용하여 대상을 지정(1개만 가능)
public class IPhone15 extends Phone{
	//Phone 의 모든 내용은 이미 가지고 있음(메소드 3개)
	
	//고유 기능만 구현하면 된다
	public void applePay() {
		System.out.println("애플페이 실행");
	}
	
}
