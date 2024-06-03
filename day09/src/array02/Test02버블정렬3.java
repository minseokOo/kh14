package array02;

public class Test02버블정렬3 {

	public static void main(String[] args) {

		//입력
		int[] data = new int[] {30,20, 10, 40, 50};
		
		//처리(Bubble sort)
		//- 인접한 두 개의 항목을 비교해가며 올바른 위치를 잡는 정렬
		
		//2회차 - 총 3번 비교 및 교체(0-1, 1-2, 2-3)
		for(int i=0; i <= 2; i++) {
			//System.out.println("i = " + i + ", i+1 = " + (i + 1));
			if(data[i] > data[i+1]) {
				int backup = data[i];
				data[i] = data[i+1];
				data[i+1] = backup;
			}
		}
		
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		
		
		
	}

}
