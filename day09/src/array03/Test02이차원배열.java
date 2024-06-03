package array03;

public class Test02이차원배열 {

	public static void main(String[] args) {
		//2차원 배열
		//- 1차원 배열이 모인 형태
		//- 표로 생각해도 좋음
		
		//(ex) 2개 반에서 각각 3명씩의 학생을 뽑아 성적 정보를 저장
		//- 1차원 배열 2개가 필요, 2차원 배열은 1개가 필요
		
		//int[] scores = new int[6];
		//scores > [0][0][0][0][0][0]
		
		int[][] scores = new int[2][3]; //[2차원][1차원]
		//scores -----> scores[0] -----> [0] [0] [0]
		//scores -----> scores[1] -----> [0] [0] [0]
		
		System.out.println(scores.length); //2 
		System.out.println(scores[0].length); //3
		System.out.println(scores[1].length); //3
		
		System.out.println(scores);//2차원 리모컨
		System.out.println(scores[0]);//1차원 리모컨
		System.out.println(scores[1]);//1차원 리모컨
		
		scores[1][1] = 50;
		System.out.println(scores[1][1]);
		
		//만약 값이 주어져 있다면?
		int[][] scores2 = new int[][] {
			{30, 50, 40}, {20, 10, 60}
		};
		System.out.println(scores2[1][1]);
	}
}
