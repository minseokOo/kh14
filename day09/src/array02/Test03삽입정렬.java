package array02;

public class Test03삽입정렬 {

	public static void main(String[] args) {
		
		int data[] = {30, 50, 20, 10, 40};
		
		
		// - 1회차 data[1]을 [0]과 비교 후 작을경우 [0]과 교체
		//총 1회 비교 1 /0
		for(int i = 0; i<=1; i++) {
			if(data[1]<data[0]) {
				int backup = data[0];
				data[0] = data[1];
				data[1] = backup;
			}
			System.out.println(data[0]);
			System.out.println(data[1]);
		}
		for(int i = 0; i<=4; i++) {
			System.out.println(data[i]);
		}
	}
}
