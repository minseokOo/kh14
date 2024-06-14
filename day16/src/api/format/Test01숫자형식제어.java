package api.format;

import java.text.DecimalFormat;

public class Test01숫자형식제어 {
	public static void main(String[] args) {
		//DecimalFormat 클래스를 이용한 숫자 형식 제어
		// - #은 값이 있을경우만 출력하는 기호
		// - 0은 값이 없으면 0으로 출력하는 기호
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		double a = 1234.56789;
		int b = 123456789;
		float c = 1.5f;
		
		System.out.println(df.format(a));
		System.out.println(df.format(b));
		System.out.println(df.format(c));
		
	}
}
