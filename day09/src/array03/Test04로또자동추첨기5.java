package array03;

import java.util.Random;

public class Test04로또자동추첨기5 {

	public static void main(String[] args) {

		Random r = new Random();

		int[][] a = new int[5][6];

		for (int k = 0; k < a.length; k++) {
			for (int i = 0; i < a[k].length; i++) {
				a[k][i] = r.nextInt(45) + 1;
			}
		}
		//정렬 - 선택정렬
		//- a[0]에 대한 정렬
		for(int i=0; i <= 4; i++) {
		int minIndex = 0;
		for(int n=0; n < a[0].length; n++) {
			if(a[0][minIndex] > a[0][i]) {
				minIndex = n;
			}
		}
		int backup = a[0][minIndex];
		a[0][minIndex] = a[0][0];
		a[0][0] = backup;
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
