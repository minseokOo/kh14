package array02;

public class Test02선택정렬 {

	public static void main(String[] args) {
		
		int numbers[] = {30, 50, 20, 10, 40};
		int minIndex = 0;
		
		// 1회차 [0]과 [1]을 비교 [0] > [1] 일시 교체
		// 
		for(int i=0; i<5; i++) {
			if (numbers[0] > numbers[1]) {
				minIndex = numbers[0];
				numbers[0] = numbers[1];
				numbers[1] = minIndex;
			}
			System.out.println(numbers[i]);
		}
		
		
	}
}
