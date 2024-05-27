package condition;

public class Test04다중조건 {

	public static void main(String[] args) {
		//조건이 여러 개인 경우에 대한 처리
		
		//입력한 월에 따른 계절 출력 프로그램
		
		int month = 12;
		
		
		
				
		if(month >= 3 && month <= 5) {
			System.out.println("봄");
		}
		else if(month >= 6 && month <=8) {
				System.out.println("여름");
			}
			else if(month >= 9 && month <=11){
				System.out.println("가을");
			}
	else {
				System.out.println("겨울");
			}
		}
	}
