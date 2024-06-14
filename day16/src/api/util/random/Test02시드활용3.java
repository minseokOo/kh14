package api.util.random;

import java.text.DecimalFormat;
import java.util.Random;

public class Test02시드활용3 {
	public static void main(String[] args) {
		// Random 클래스로 OTP번호 만들기
		// 사용자마다 다르게 값이 나오려면?
		// 사용자마다 시드가 다르면 된다 (아이디 or 일련번호)

		Random r = new Random();

		String user1 = "khacademy";
		String user2 = "javamaster";

		long current = System.currentTimeMillis();

		long period = current / 10000;
		r.setSeed(period);

		DecimalFormat df = new DecimalFormat("000000");

		// user1에 대한 otp
		r.setSeed(period + user1.hashCode());
		int otp = r.nextInt(1000000);
		System.out.println("user1에 대한 otp : " + df.format(otp));
		
		// user2에 대한 otp
		r.setSeed(period + user2.hashCode());

		otp = r.nextInt(1000000);
		System.out.println("user2에 대한 otp : " + df.format(otp));

	}
}
