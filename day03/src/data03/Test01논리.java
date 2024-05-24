package data03;

public class Test01논리 {

	public static void main(String[] args) {
//		논리
//		- true(참), false(거짓)을 저장하기 위한 형태
//		- 자료형의 이름은 boolean
		
		boolean a = true; // true나 false만 적을수있음
		
//		(Q) 가진돈이 2만원일 때, 
//		8천원 짜리 짜장면과 1만 5천원 짜리 탕수육을 주문 할 수 있나요?
		
		int money = 20000;
		int jja = 8000;
		int tang = 15000;
		
		boolean order = money >= jja + tang;
		System.out.println(order);
		
//		비교 연산
//		- 숫자를 비교하여 논리를 만들어내는 연산(계산)
//		- 크다(>), 작다(<), 이상(>=), 이하(<=), 같다(==), 다르다 (!=)
		
	}

}
