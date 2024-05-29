package loop;

public class Test05숫자찾기 {
	public static void main(String[] args) {
		
		for (int i = 1; i < 100; i++) {
			
			int six = (i %10);
			int sixTen = (i / 10);
			
			if (six == 6) {
				System.out.println("6이 들어간 숫자 : " + i);
			}
			else if (sixTen == 6) {
				System.out.println("6이 들어간 숫자 : " + i);
			}
		}
		
	}
}
