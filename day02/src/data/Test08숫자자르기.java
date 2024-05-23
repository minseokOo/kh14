package data;

public class Test08숫자자르기 {

	public static void main(String[] args) {
		
		//(Q) a에 들어있는 숫자의 일의 자리만, 십의 자리만 출력
		int a = 15;
		int b = a/10;//10의 자리
		int c = a % 10; //1의 자리
		System.out.println(b);
		System.out.println(c);
		
		int time = 1203;
		int hour = time / 100;
		int minute = time % 100;
		
		System.out.println(hour);
		System.out.println(minute);
		
		int number = 314513;
		int number2 = number / 1000;
		int number3 = number % 1000;
		
		//(Q) birth의 연, 월, 일을 각각 출력
		int birth = 20050315;
		int year = birth / 10000;
		int month = (birth / 100) % 100;
		int day = birth % 100;
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
	}

}
