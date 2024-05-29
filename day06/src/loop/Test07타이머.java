package loop;

import java.util.Scanner;

public class Test07타이머 {

	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
	
	int time = sc.nextInt();
	int minute = time / 100;
	int second = time % 100;
	
	int total = (60 * minute) + second;
	// second는 1초씩 줄어듬
	// second가 0이 됐을때 minute -1 을 하고 second를 59로 만듬
	// second와 minute가 0이 됐을때 시간이 다 되었습니다!
	for(int i = total; i >= 0; i--) { // second는 1초씩 줄어듬
		if (i < 60) {
			int min = i / 60;
			int sec = i % 60;	
			System.out.println(min+ "분" + sec + "초");
			
		}
		
		}
		
		
		
		

		
	
	
	
	}
}
