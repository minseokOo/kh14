package loop;

public class Test06삼육구게임 {

	public static void main(String[] args) {
		
		for (int i=1; i <1000; i++) {
		int one = i % 10;
		int ten = i % 100 / 10;
		int hundred = i / 100;
		
		boolean a = one == 3 || one == 6 || one == 9; //일의 자리 369
		boolean b = ten == 3 || ten == 6 || ten == 9; // 십의 자리 369
		boolean c = hundred == 3 || hundred == 6 || hundred == 9; //백의 자리 369
		
		if (!a && !b && !c) {
			System.out.println(i + "!");
		}
		
		
		
		if (a && b && c) { //일의 자리 && 십의 자리 && 백의 자리
			System.out.println("짝짝짝! (" + i + ")");
		}
		else if (!a && b && c) { //십의 자리 && 백의 자리
			System.out.println("짝짝! (" + i + ")");
		}
		else if (a && !b && c) { //일의 자리 && 백의 자리
			System.out.println("짝짝! (" + i + ")");
		}
		else if (a && b && !c) { //일의 자리 && 십의 자리
			System.out.println("짝짝! (" + i + ")");
		}
		else if (a || b || c) { //일 or 십 or 백
			System.out.println("짝! (" + i + ")");
		}
		
	}
	
	
	}
}
