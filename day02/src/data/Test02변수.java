package data;

public class Test02변수 {

	public static void main(String[] args) {
		//변수(Variable)
		//- 값 또는 식의 결과를 잠시 저장해두는 도구
		//- 만들 때 형태와 이름을 지정해야 함
		int a = 8000 * 2;//a에 8000 * 2를 계산한 결과를 넣어라
		int b = 10000 * 3;//b에 10000 * 3을 계산한 결과를 넣어라
		System.out.println(a);//a에 저장된 값을 출력해라
		System.out.println(b);//b에 저장된 값을 출력해라
		System.out.println(a + b);
		
		//더 완벽한 구조가 되려면 짜장면 금액, 수량, 짬뽕 금액, 수량을 전부 다 계산해야한다
		int jjm = 8000;
		int jb = 10000;
		int jjmCount = 2;
		int jbCount = 3;
		
		int jjmTotal = jjm * jjmCount;//짜장면 합계
		int jbTotal = jb * jbCount;//짬뽕 합계
		int total = jjmTotal + jbTotal;//전체 합계
		
		System.out.println(jjmTotal);
		System.out.println(jbTotal);
		System.out.println(total);
		
	}

}
