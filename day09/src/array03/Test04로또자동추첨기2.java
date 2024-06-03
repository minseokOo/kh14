package array03;

import java.util.Random;

public class Test04로또자동추첨기2 {

	public static void main(String[] args) {

		Random r = new Random();
		
		
		int[][] a = new int [][] {
			{r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1 },
			{r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1 },
			{r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1 },
			{r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1 },
			{r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1, r.nextInt(45)+1 }
		};
		for(int k = 0; k < 5; k++) {
			System.out.println((k+1) + "회차");
		for(int i=0; i<6; i++) {
			int backup = 0;
			if (a[k][i]<a[k][i+1]) {
				backup = a[k][i];
				a[k][i] = a[k][i+1];
				a[k][i+1] = backup;
				}
			System.out.println(a[k][i]);
			
		}
		System.out.println("-----------");
		}
		
	}

}
