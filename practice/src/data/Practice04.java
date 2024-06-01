package data;

public class Practice04 {

	public static void main(String[] args) {

//		- 년이 정확하게 365.24xx 일 입니다.
//		- 4년마다 하루를 더 부여하고,
//		- 100년마다 하루를 덜 부여하고,
//		- 400년마다 하루를 더 부여합니다.
//		- 2000년은 윤년입니다. (400의 배수라서)(가장 강력한 조건)
//		- 2100년은 윤년이 아닙니다. (100의 배수라서)
//		- 2024년은 윤년입니다. (400의 배수가 아니고 100의 배수는
//		아니지만 4의 배수이기 때문.)
		
		int now = 52;
		boolean fourHundred = now % 400 == 0;
		boolean one = now % 100 != 0;
		boolean four = now % 4 == 0;
		
		boolean a =  one && four || fourHundred;;
		
		System.out.println(a);
		
		
		
		
	}

}
