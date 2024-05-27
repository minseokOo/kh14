package condition;

public class Test01조건 {

	public static void main(String[] args) {
//		조건(Condition)
//		- 상황에 따라 코드를 실행시키는 구문
//		- 상황이란 논리적인 판정식을 의미
		
		
		//입력
		int number = 5;
		
		//계산
		boolean isOdd = number % 2 == 1;
		boolean isEven = number % 2 ==0;
		
		
		//출력
//		if(number를 2로 나눈 나머지가 1일 때) {
//			
//		}
		if(isOdd == true) {
			System.out.println("홀수");
			
		}
		if(isEven == true) {
			System.out.println("짝수");
			
		}
		
		
	}
}
