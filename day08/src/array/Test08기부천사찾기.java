package array;

public class Test08기부천사찾기 {

	public static void main(String[] args) {
		
		//입력
		int donates[] = new int[] {100000, 5000000, 5000, 70000, 300000};
		
		//계산
		int maxIndex = 0; //맨 앞이 제일크다고 가정
		
		for(int i=1 ; i < donates.length ; i++) {
			//System.out.print(donates[maxIndex]);
			//System.out.print(" vs ");
			//System.out.println(donates[i]);
			if(donates[maxIndex] < donates[i]) {
				maxIndex = i;
			}
			
			
		}
		//결과 i+1 번째가 가장 크다
		System.out.println("가장 큰 데이터는 " + maxIndex + "번 위치에 있습니다");
		System.out.println("가장 큰 숫자는 " + donates[maxIndex]);
	}
}
