package array02;

public class Test02선택정렬2 {

	public static void main(String[] args) {
		
		int numbers[] = {30, 50, 20, 10, 40};
		int minIndex = 0;
		
		// 2회차 [1]과 [2]을 비교 [1] > [2] 일시 교체
		// 
		for(int i=0; i<5; i++) {
			if (numbers[1] > numbers[2]) {
				minIndex = numbers[1];
				numbers[1] = numbers[2];
				numbers[2] = minIndex;
			}
			System.out.println(numbers[i]);
		}
		
		
	}
}
