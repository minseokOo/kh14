package data03;

public class Test03숫자판정 {

	public static void main(String[] args) {
		
		int number = 71;
		
		int step1 = number % 2;
		boolean a = step1 < 1;
		System.out.println(number + "는 짝수 인가?");
		System.out.println(a);
		
		
		int step2 = number % 3;
		boolean b = step2 == 0;
		System.out.println(number + "는 3의 배수인가?");
		System.out.println(b);
		
		
		boolean step3 = number / 10 ==7;
		boolean step4 = number % 10 ==7;
		
		
		boolean seven = step3 || step4;
		System.out.println(seven);
	}

}
