package array02;

public class Test01선택정렬 {

	public static void main(String[] args) {

		int numbers[] = new int[] { 30, 50, 20, 10, 40 };
		int first = 0;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i]>numbers[j]) {
					first = numbers[i];
					numbers[i] = numbers [j];
					numbers[j] = first;
					
				}
				
				
			}

			System.out.println(numbers[i]);
		}

	}

}
