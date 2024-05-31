package array;

public class Test01배열 {

	public static void main(String[] args) {
		
		//배열(Array)
//		- 변수를 묶어놓은 형태.
//		(ex) 정수 세 개를 묶어서 사용하기 위한 배열
		
		//arr ------> [?] [?] [?]
		int[] arr = new int[3];  // int a = ? , int b = ? , int c = ?
		//System.out.println("arr = " + arr); //리모컨 정보 출력(의미없음)
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		//arr[3] = 40; error
		
		
		
		System.out.println(arr[0]); //+0 지점
		System.out.println(arr[1]); //+1 지점
		System.out.println(arr[2]); //+2 지점
		
		
	}
}
