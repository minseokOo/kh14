package data;

public class Test06시간계산기 {
	public static void main(String[] args) {

// (1)		750분이 몇시간 몇분인지 구하여 출력하시오.
		int question = 750;
		int hour = 60;
		int time = (question / hour);
		int min = (question % hour);
		
		System.out.println(time +"시간 " + min + "분");
		System.out.println( );
// (2)		2시간 40분 + 3시간 25분의 결과를 출력하시오.
		int a = 2;
		int b = 40;
		int c = 3;
		int d = 25;
		
		int aMin = (a * hour);
		int cMin = (c * hour);
		int totalTime = (aMin + cMin + b + d);
		int totalHour = (totalTime / hour);
		int totalMin = (totalTime % hour);
		
		System.out.println(a + "시간 " + b +"분 + " + c + "시간 " + d + "분을 더하면?");
		System.out.println("두 시간의 합은 " + totalHour + "시간" + totalMin + "분 입니다.");
	}
}
