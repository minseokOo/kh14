package condition2;

public class Test01Switch구문 {

	public static void main(String[] args) {
		
//		if구문의 단 하나의 단점
//		- 질문을 순차적으로 한다는 것
//		- 평소에는 문제가 되지 않지만 모든 경우가 동시 처리 되어야 하는 경우 문제
//		- 예를 들면 키보드 버튼처리 또는 마우스 버튼 처리 등
		
		int level = 3; //학년
		
		//level의 값을 토대로 특정 코드가 실행되도록 switch 구문을 구성
		switch(level) {
		case 1:
			System.out.println("병아리");
			break;
		case 2:
			System.out.println("토끼");
			break;
		case 3:
			System.out.println("오리");
			break;
		case 4:
			System.out.println("사슴");
			break;
		case 5:
			System.out.println("여우");
			break;
		case 6:
			System.out.println("호랑이");
			break;
		}
		
		
		
		
	}
}
