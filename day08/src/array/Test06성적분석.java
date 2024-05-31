package array;

public class Test06성적분석 {

	public static void main(String[] args) {

		int[] score = new int[] { 70, 85, 82, 96, 77, 64, 48, 55, 90, 82 };
		int nScore = 80;
		int total = 0;
		int count = 1;

		System.out.println("모든 학생의 점수 : ");
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + "점");
			if (i < score.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("재평가 대상자 점수 : ");
		for (int i = 0; i < score.length; i++) {
			if (score[i] < 60) {
				System.out.println(score[i] + "점");
			}
		}
		System.out.println("성적 우수자 점수 : ");
		for (int i = 0; i < score.length; i++) {
			if (score[i] >= 90) {
				System.out.println(score[i] + "점");
			}
		}
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		for (int i = 0; i < score.length; i++) {
			if (score[i] > nScore) {
				count++;
			}
		}
		System.out.println("총점 : " + total + "점");
		float average = (float) total / score.length;
		System.out.println("평균 : " + average + "점");
		System.out.println("전학생의 점수 : " + nScore + "점");
		System.out.println("전학생의 등수는 " + count + "등 입니다.");
		
		
	}
}
