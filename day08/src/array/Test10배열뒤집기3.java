package array;

public class Test10배열뒤집기3 {

	public static void main(String[] args) {

		int[] data = new int[] { 1, 2, 3, 4, 5 };

		int left = 0, right = data.length - 1;
		for (int i = 0; i < data.length/2; i++) {
			int backup = data[left];
			data[left] = data[right];
			data[right] = backup;

			left++;
			right--;
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
