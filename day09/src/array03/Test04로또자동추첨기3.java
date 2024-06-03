package array03;

import java.util.Random;

public class Test04로또자동추첨기3 {

	public static void main(String[] args) {

		Random r = new Random();

		int[][] a = new int[5][6];

		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < a[k].length; i++) {
				a[k][i] = r.nextInt(45) + 1;
			}
		}
		for (int k = 0; k < a.length; k++) {
			System.out.println((k + 1) + "회차");
			for (int i = 0; i < a[k].length; i++) {
				System.out.println(a[k][i]);
			}
		}
		System.out.println("-----------");
	}

}
