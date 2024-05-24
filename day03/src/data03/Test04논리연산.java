package data03;

public class Test04논리연산 {

	public static void main(String[] args) {

//		(Q) 어떤 사람의 나이가 "청소년"에 해당하는지 판정하세요.
//		- 청소년이란 나이가 14살 이상 20살 미만을 의미한다.
//		- &&(and) 연산을 하면 좌우가 모두 참일 때 참이 나온다.
		
		int age = 14;
		
		boolean teen = 14 <= age && age < 20;
		System.out.println(teen);
		
//		(Q) 어떤 사람의 나이가 "무임승차" 대상인지 판정
//		- 8살 미만이거나 65세 이상일 경우 무임승차 대상이다.
		
		 boolean free = age < 8 || age >= 65;
		 System.out.println(free);
	}

}
