package condition2;

public class Test01Switch구문2 {

	public static void main(String[] args) {
		
//		if구문의 단 하나의 단점
//		- 질문을 순차적으로 한다는 것
//		- 평소에는 문제가 되지 않지만 모든 경우가 동시 처리 되어야 하는 경우 문제
//		- 예를 들면 키보드 버튼처리 또는 마우스 버튼 처리 등
		
		int level = 3; //학년
		
		//level의 값을 토대로 특정 코드가 실행되도록 switch 구문을 구성
//		1,2학년을 토끼, 3,4학년을 사슴, 5,6학년을 호랑이라고 부르고 싶다면?
		switch(level) {
		case 1:
		case 2:
			System.out.println("토끼");
			break;
		case 3:
		case 4:
			System.out.println("사슴");
			break;
		case 5:
		case 6:
			System.out.println("호랑이");
			break;
		}
		
		
		
		
	}
}
