package array02;

public class Test01선택정렬5 {

	public static void main(String[] args) {

		int[] data = new int[] { 30, 20, 50, 10, 40 };

		// 처리
		for(int k = 0; k < data.length - 1; k++) {
			
		
		// - k회차 : data [k]부터 data[4]까지 가장 작은 값을 찾아 맨 앞과 교체
		// - [k]이 가장 작은 값의 위치라고 가정
		int minIndex = k;

		// - [k+1]부터 [4] 사이의 값들과 비교하여 최소값 위치를 조정
		for (int i = k+1; i < data.length; i++) {
			if (data[minIndex] > data[i]) { // 최소값 > 현재값
				minIndex = i;
			}
		}
		System.out.println("minIndex = " + minIndex);

		// - 위에서 나온 최소값 위치와 [1]의 값을 교체
		int backup = data[k];
		data[k] = data[minIndex];
		data[minIndex] = backup;

		}
		for (int i = 0; i < 5; i++) {
			System.out.println(data[i]);
		}
	}

}
