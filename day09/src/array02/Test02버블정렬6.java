package array02;

public class Test02버블정렬6 {

	public static void main(String[] args) {

		// 입력
		int[] data = new int[] { 30, 50, 20, 10, 40 };

		// 처리(Bubble sort)
		// - 인접한 두 개의 항목을 비교해가며 올바른 위치를 잡는 정렬
		for (int k = data.length - 2; k >= 0; k--) {
			// 1회차 - 총 4번 비교 및 교체(0-1, 1-2, 2-3, 3-4)
			for (int i = 0; i <= k; i++) {
				// System.out.println("i = " + i + ", i+1 = " + (i + 1));
				if (data[i] > data[i + 1]) {
					int backup = data[i];
					data[i] = data[i + 1];
					data[i + 1] = backup;
				}
			}
		}

		// 출력
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}

	}

}
