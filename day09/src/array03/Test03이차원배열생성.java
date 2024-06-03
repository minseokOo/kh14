package array03;

public class Test03이차원배열생성 {

	public static void main(String[] args) {
		//{170.2, 180.5, 165.8, 172.9}
		//{163.5, 166.7, 171.5, 178.0}
		
		double[][] a = new double [2][4];
		a[0][0] = 170.2;
		a[0][1] = 180.5;
		a[0][2] = 165.8;
		a[0][3] = 172.9;
		a[1][0] = 163.5;
		a[1][1] = 166.7;
		a[1][2] = 171.5;
		a[1][3] = 178.0;
		for(int k=0; k<2; k++) {
		for(int i=0; i < 4; i++) {
			System.out.println(a[k][i]);
		}
		}
	}
}
