package array;

public class Test02배열연습 {

	public static void main(String[] args) {
		
		int arr[] = new int [5];
		System.out.println(arr.length); // arr 가 몇 칸으로 만들어 졌는지
		
		arr[0] = 30;
		arr[1] = 50;
		arr[2] = 20;
		arr[3] = 10;
		arr[4] = 40;
		System.out.print("1번 데이터 - '"+ arr[0] + "', '");
		System.out.print(arr[1] + "', '");
		System.out.print(arr[2] + "', '");
		System.out.print(arr[3] + "', '");
		System.out.println(arr[4] + "'");
		
		double arra[] = new double [5];
		arra[0] = 3.14d;
		arra[1] = 2.79d;
		arra[2] = 5.32d;
		arra[3] = 6.48d;
		arra[4] = 4.47d;
		System.out.print("2번 데이터 - '"+ arra[0] + "', '");
		System.out.print(arra[1] + "', '");
		System.out.print(arra[2] + "', '");
		System.out.print(arra[3] + "', '");
		System.out.println(arra[4] + "'");
		
		String array[] = new String [4];
		array[0] = "자바";
		array[1] = "스프링";
		array[2] = "안드로이드";
		array[3] = "스파크";
		System.out.print("3번 데이터 - '"+ array[0] + "', '");
		System.out.print(array[1] + "', '");
		System.out.print(array[2] + "', '");
		System.out.print(array[3] + "'");
		
	}
}
