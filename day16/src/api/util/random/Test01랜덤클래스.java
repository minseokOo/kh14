package api.util.random;

import java.util.Random;

public class Test01랜덤클래스 {
	public static void main(String[] args) {
		//Random 클래스
		// - 랜덤 데이터를 종류별로 반환하는 클래스
		// - 시드(seed)를 기반으로 계산을 하며, 같은 시드면 같은 결과가 나온다
		// - 정수 뿐 아니라 다른 형태의 값을 반환하는 메소드가 존재
		
		//객체  생성
		Random r1 = new Random();
		Random r2 = new Random(1L);
		
		int dice1 = r1.nextInt(6) + 1;
		int dice2 = r2.nextInt(6) + 1;
		
		System.out.println("dice1 = " + dice1);
		System.out.println("dice2 = " + dice2);
		
		System.out.println(r1.nextBoolean());
		System.out.println(r1.nextLong());
		System.out.println(r1.nextFloat()); //0.xx (0이상 1미만)
		System.out.println(r1.nextDouble()); //0.xxxx
		System.out.println(r1.nextGaussian());
		
	}
}
