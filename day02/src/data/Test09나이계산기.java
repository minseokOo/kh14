package data;

public class Test09나이계산기 {

	public static void main(String[] args) {
		
		//- 한국나이 : 태어나면 1살, 해가 바뀌면 1살 늘도록 계산
		//- 만나이 : 태어난지 12개월 마다 1살로 계산
		
		int birth = 20000101;
		//이 날 태어난 사람의 한국 나이와 만 나이를 구하시오.
		
		int today = 20240523; //오늘 날짜
		//한국나이 계산
		int kBirth = birth / 10000;
		int kToday = today / 10000;
		int krAge = (kToday - kBirth) + 1; //한국 나이
		
		System.out.println("한국 나이는 " + krAge + "살 입니다.");
		
		//만 나이 계산
		int yDay = today - birth;
		int yAge = yDay / 10000; //만나이
		
		System.out.println("만 나이는 " + yAge + "살 입니다.");
				
		
	}

}
