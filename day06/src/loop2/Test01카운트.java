package loop2;

public class Test01카운트 {

	public static void main(String[] args) {
//		(Q) 1부터 10 사이의 홀수는 몇 개인가요?
	
		//카운트 측정 변수를 0으로 생성
		int count = 0;
		
		for(int i = 1 ; i <= 10; i++) {
			if(i % 2 !=0) {
				//System.out.println(i);
				count++;
			}
		}
	//반복이 끝나고 확인
		System.out.println("count : " + count);
	
	}

}
