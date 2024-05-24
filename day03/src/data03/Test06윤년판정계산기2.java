package data03;

public class Test06윤년판정계산기2 {

	public static void main(String[] args) {

		
//		- 년이 정확하게 365.24xx 일 입니다.
//		- 4년마다 하루를 더 부여하고,
//		- 100년마다 하루를 덜 부여하고,
//		- 400년마다 하루를 더 부여합니다.
//		- 2000년은 윤년입니다. (400의 배수라서)(가장 강력한 조건)
//		- 2100년은 윤년이 아닙니다. (100의 배수라서)
//		- 2024년은 윤년입니다. (400의 배수가 아니고 100의 배수는
//		아니지만 4의 배수이기 때문.)
		
        
		int year = 2040;
		
		//조건 1 : 400의 배수인가.
		boolean y400 = year % 400 == 0;
		
		
		//조건 2 : 100의 배수인가.
		boolean y100 = year % 100 ==0;
		
		//조건 2-1 : 100의 배수가 아닌가. (윤년x)
		boolean y100x = year % 100 != 0;
		
		//조건 3 : 4의 배수인가.
		boolean y4 = year % 4 == 0;
		
		//case1 : 400의 배수이며 100의 배수인가.
		boolean case1 = y400 && y100 == true;
		
		//case2 : 400의 배수가 아니며 100의 배수인가. (윤년x)
		boolean case2 = y100 != y400;
		case2 = false;
		
		//case3 : 100의 배수가 아니며 4의 배수인가.
		boolean case3 = y4 && y100x;
		
		
		
		boolean answer = case1 || case2 || case3;
		
		System.out.println(answer);
		
		
	}

}
