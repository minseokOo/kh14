package data;

public class Test06시간계산기2 {
	public static void main(String[] args) {

// (1)		750분이 몇시간 몇분인지 구하여 출력하시오.
		int question = 750;
		int hour = 60;
		int time = (question / hour);
		int min = (question % hour);
		
		System.out.println(time +"시간 " + min + "분");
		System.out.println( );
// (2)		2시간 40분 + 3시간 25분의 결과를 출력하시오.
		int a = 2;  //첫번째 시간
		int b = 40; //첫번째 분
		int c = 3; //두번째 시간
		int d = 25; //두번째 분
		
		int m3 = (b + d);
		int m4 = (m3 / hour);
		int m5 = (m3 % hour);
		
		
		System.out.println((a + c + m4) + "시간 " + m5 + "분");
	}
}
