package loop3;

public class Test02몸짱프로젝트 {

	public static void main(String[] args) {

		int pushUp = 1; // 첫날 푸쉬업 횟수

		for (int i = 1; i <= 30; i++) { // 그 날 한 횟수

			pushUp += 3;
			System.out.println(i + "일차 : " + (pushUp - 3) + "회");
		}

	}
}
