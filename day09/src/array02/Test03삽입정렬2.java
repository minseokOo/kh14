package array02;

public class Test03삽입정렬2 {

	public static void main(String[] args) {
		
		int data[] = {30, 50, 20, 10, 40};
		
		// - 2회차 data[2]을 [1], [0]과 비교 후 작을경우 [1] or [0]과 교체
		// - 총 2회 비교 2/ 1, 2/0 
		for(int i = 0; i<=4; i++) {
			int backup = 0;
			if(data[1]<data[0]) {
				backup = data[1];
				data[1] = data[0];
				data[0] = backup;}
			
			if(data[2]<data[1]) {
				backup = data[2];
				data[2] = data[1];
				data[1] = backup;
			}
			if(data[3]<data[2]) {
				backup = data[3];
				data[3] = data[2];
				data[2] = backup;
			}
			if(data[4]<data[3]) {
				backup = data[4];
				data[4] = data[3];
				data[3] = backup;
			}
		}
		for(int i = 0; i<=4; i++) {
		System.out.println(data[i]);
		}
	}
}
