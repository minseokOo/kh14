package condition;

import java.util.Scanner;

public class Test03시험판독기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int korean = sc.nextInt();
		System.out.print("영어 점수 : ");
		int english = sc.nextInt();
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		
		int total = korean + english + math;
		float average = (float)total / 3;
		
		//case1 합격은 평균점수가 60점 이상이어야한다.
		boolean case1 = average >= 60;
		
		//case2 각 과목이 40점 이상이어야 한다.
		boolean case2 = korean >= 40 && english >= 40 && math >=40;
		
		if (case1 && case2) {
			System.out.println("합격입니다.");
		}
		else {
			System.out.println("불합격입니다.");
		}
	}
}
