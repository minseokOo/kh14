package loop3;

public class Test02몸짱프로젝트2 {

	public static void main(String[] args) {

		int pushUp = 1; // 첫날 푸쉬업 횟수
		int plus = 3;
		int total = 0;
		
		for (int i = 1; i <= 30; i++) { // 그 날 한 횟수

			System.out.println(i + "일차 : " + pushUp + "회");
			total += pushUp;
			pushUp += plus;
			
		
		}
		System.out.println("총 " + total + "개의 푸쉬업을 하게 됩니다.");
		
		
	}
}
