package array;

public class Test09위치바꾸기 {

	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		int dataSave = data[0];
//		(Q)30이랑 10이랑 위치를 바꾸세요
		data[0] = data[3];
		data[3] = dataSave;
		
		dataSave = data[4];
		data[4] = data[1];
		data[1] = dataSave;
		
		
		
		
		
		//출력
		for(int i = 0 ; i < data.length; i++) {
			System.out.println(data[i]);
		}
		
	}
}
