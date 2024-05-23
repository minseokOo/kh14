package data;

public class Test01데이터 {

	public static void main(String[] args) {
			//데이터(Data)란?
			//- 계산을 위해 필요한 값(돈, 키, 체중, 넓이)
			//- 종류별로 구분됨 ex) cm, kg
			//- 프로그래밍에서는 단위는 쓰지 않음(상식으로 커버)
			//- 단위 대신 데이터의 형태를 가지고 구분
			//- 정수(소수점X), 실수(소수점O), 문자, 논리, 문자열 등으로 구분
		System.out.println(10 + 300);//정수끼리 계산
		System.out.println(10.0 + 300.0);//실수끼리 계산
		
		//(Q) 짜장면 8천원, 짬뽕 1만원일 때 짜장면 2그릇, 짬뽕 3그릇 가격은?
		System.out.println(8000 * 2+10000 * 3);
		
		//소계까지 같이 보여주려면?
		System.out.println(8000 * 2);//짜장면 금액 합계
		System.out.println(10000 * 3);//짬뽕 금액 합계
		System.out.println(8000 * 2 + 10000 * 3);//전체 합계
			
	}

}
