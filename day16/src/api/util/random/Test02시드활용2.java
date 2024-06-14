package api.util.random;

import java.text.DecimalFormat;
import java.util.Random;

public class Test02시드활용2 {
	public static void main(String[] args) {
		//Random 클래스로 OTP번호 만들기
		
		Random r = new Random();
		
		long current = System.currentTimeMillis();
		System.out.println(current);
		long period = current / 10000;
		System.out.println(period);
		r.setSeed(period);
		
		int otp = r.nextInt(1000000);
		
		DecimalFormat df = new DecimalFormat("000000");
		System.out.println(df.format(otp));
		
	}
}
