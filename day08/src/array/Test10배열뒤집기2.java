package array;

public class Test10배열뒤집기2 {

	public static void main(String[] args) {

		int[] data = new int[] { 1, 2, 3, 4, 5 };
		int backUp = 0;
		int count = 0; // 양옆 count 번째 숫자 교환

		
		for (int i = 0; i < data.length; i++) {
			if (count < (data.length/2)) {
				count++;
				backUp = data[count - 1];
				data[count - 1] = data[data.length - count];
				data[data.length - count] = backUp;
			}
		}

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
