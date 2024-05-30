package loop3;

public class Test03현명한노인 {

	public static void main(String[] args) {
		
		long start = 1;
		long total = 0;
		
		for(int i = 1; i <=40; i++) { //1 2 4 8 16
			
			System.out.println(i + "일차 : " + start + "원");
			total += start;
			start += start;
		}
		System.out.println("총 " + total + "원을 받았습니다.");
	}
}
