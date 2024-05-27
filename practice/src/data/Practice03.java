package data;

public class Practice03 {

	public static void main(String[] args) {

		//Test05건강검진대상자판정
		//건강검진은 30세 이상인 사람들을 대상으로 2년에 한 번씩 진행합니다.

//		올해가 홀수 해라면 홀수 해에 태어난 사람들이 대상자
//		올해가 짝수 해라면 짝수 해에 태어난 사람들이 대상자

//		어떤 사람의 생년월일 8자리를 입력받아 건강검진 대상자인지 판정 후 출력
		
		int birth = 19970825;
		int today = 20240526;
		
		int birthYear = birth / 10000;
		int todayYear = today / 10000;
		
		int age = (todayYear - birthYear) + 1;
		boolean a = age >= 30;
		
		int evenBirth = birthYear % 2;
		int evenToday = todayYear % 2;
		
		boolean b = evenBirth == evenToday;
		System.out.println(a);
		
	}

}
