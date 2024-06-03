package array02;

public class Test01선택정렬3 {

	public static void main(String[] args) {

		int[] data = new int[] { 10, 50, 20, 30, 40 };

		// 처리
		// - 1회차 : data [1]부터 data[4]까지 가장 작은 값을 찾아 맨 앞과 교체
		// - [1]이 가장 작은 값의 위치라고 가정
		int minIndex = 1;

		// - [2]부터 [4] 사이의 값들과 비교하여 최소값 위치를 조정
		for (int i = 2; i <= 4; i++) {
			if (data[minIndex] > data[i]) { // 최소값 > 현재값
				minIndex = i;
			}
		}
		System.out.println("minIndex = " + minIndex);

		// - 위에서 나온 최소값 위치와 [1]의 값을 교체
		int backup = data[1];
		data[1] = data[minIndex];
		data[minIndex] = backup;

		for (int i = 0; i < 5; i++) {
			System.out.println(data[i]);
		}

	}

}
