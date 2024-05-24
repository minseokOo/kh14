package data03;

public class Test02성인인증프로그램 {

	public static void main(String[] args) {

		int birth = 19970825;
		int today = 20240524;
		int krAge = (today / 10000) - (birth / 10000) + 1;
		int adultAge = 20;
		
		boolean able = krAge >= adultAge;
		
		System.out.println(able);
	}

}
