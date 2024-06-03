package array02;

public class Test03삽입정렬3 {

	public static void main(String[] args) {

		//입력
		int[] data = {30, 50, 20, 10, 40};
		
		//처리 - 삽입정렬(Inserting Sort)
		
		//- 2번 자리의 데이터를 백업한다
		int position =2; 
		int backup = data[position];
		//들어갈 위치를 만든다(position에 변화를 준다)
		for(int i = position-1; i>=0; i--) {
			if(data[i] < backup) {break;}
		
		position--;
		data[i+1] = data[i]; 
		}
		//계산된 위치에 백업 데이터를 추가한다
		data[position] = backup;
		
		//- 1, 0과 순서대로 비교해가며 더 작은 값이 나오기 전까지 진행한다
		
		
		
		
		//출력
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		
		
	}

}
