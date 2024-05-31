package array;

public class Test10배열뒤집기 {

	public static void main(String[] args) {

		int[] data  = new int[] {30, 50, 20, 10, 40};
		int backUp = 0;
		
		
		
		backUp = data[0];
		data[0] = data[4];
		data[4] = backUp;
		
		backUp = data[1];
		data[1] = data[3];
		data[3] = backUp;
		
		
		
		for(int i = 0; i < data.length; i++) {
		System.out.println(data[i]);
		}
	}

}
