package array03;

public class Test01배열의차원 {

	public static void main(String[] args) {

		//차원(Dimension)
//		- 데이터를 바라보는 관점
//		- 0차원이면 데이터간의 관계가 없다고 봄(점으로 본다, 변수)
//		- 1차원이면 데이터간의 직선 관계가 있다고 봄(선으로 본다, 배열)
//		- 2차원이면 데이터간의 관계를 평면으로 본다
//		- 3차원이면 데이터간의 관계를 입체로 본다
//		- ...
		
//		(예) 학생 300명의 성적 정보를 저장하세요!
//		- 0차원 : 변수 300개 (학생 300명)
//		- 1차원 : 1차원 배열 1개 (1개 학년으로 생각) 
		int[] a = new int[300];
//		- 2차원 : 2차원 배열 1개 = 1차원 배열 여러개 (여러개의 반으로 생각)
		int[][] b = new int[10][30];//30명씩 10개반
//		- 3차원 : 2차원 배열 여러개의 모음 (1개의 학교로 생각)
		int[][][] c = new int [3][5][20];//3개 학년의 5개의 반씩 20명
		
	}

}
