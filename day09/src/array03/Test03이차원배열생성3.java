package array03;

public class Test03이차원배열생성3 {

	public static void main(String[] args) {
		//{170.2, 180.5, 165.8, 172.9}
		//{163.5, 166.7, 171.5, 178.0}
		
		double[][] a = new double [][] {
			{170.2, 180.5, 165.8, 172.9}, {163.5, 166.7, 171.5, 178.0}
		};
		
		for(int i=0; i<a.length; i++) { //2차원
		for(int k=0; k < a[i].length; k++) { //1차원
			System.out.println(a[i][k]);
		}
		System.out.println("---------");
		}
	}
}
