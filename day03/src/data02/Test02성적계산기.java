package data02;

public class Test02성적계산기 {

	public static void main(String[] args) {

//		어떤 학생의 중간고사 성적은 다음과 같습니다.
//		- 국어 : 80점
//		- 영어 : 90점
//		- 수학 : 95점
//		
//		이 학생의 '총점'과 '평균'을 구하여 화면에 출력하세요.
		
		int korean = 80;
		int english = 90;
		int math = 95;
		
		int totalgrade = korean + english + math;
		float avg = totalgrade / 3f;
		double average = totalgrade / 3d;
		double average2 = (double)totalgrade / 3;
				
		System.out.println(average2);
		
		
		System.out.println("중간고사 총점은 " + totalgrade + "점 입니다.");
		System.out.println("평균점수는 " + average + "점 입니다.");
	}

}
