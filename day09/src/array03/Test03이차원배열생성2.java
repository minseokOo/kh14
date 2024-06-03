package array03;

public class Test03이차원배열생성2 {

	public static void main(String[] args) {
		//{170.2, 180.5, 165.8, 172.9}
		//{163.5, 166.7, 171.5, 178.0}
		
		double[][] a = new double [][] {
			{170.2, 180.5, 165.8, 172.9}, {163.5, 166.7, 171.5, 178.0}
		};
		
		for(int k=0; k<2; k++) {
		for(int i=0; i < 4; i++) {
			System.out.println(a[k][i]);
		}
		}
	}
}
