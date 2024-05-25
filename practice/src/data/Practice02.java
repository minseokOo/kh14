package data;

public class Practice02 {

	public static void main(String[] args) {

//		복리 계산기
//		- 한달에 20프로씩 이자로 주는 금융 상품이 있습니다.
//		- 오늘을 기준으로 시작하고 100원을 넣었습니다. 
//		- 2024년 6월 26일에 얼마가 되는지 구하시오.
		
		
		//입력
		int amout = 1600000; //투자 금액
		
		int interestRate = 20; //이자율
		double interestRate2 = 1+(double)interestRate * 0.01;
		
		int sYear = 2024; //년
		int sMonth = 5; //월
		int sDay = 25; //일
		
		int eYear = 2024; //년
		int eMonth = 7; //월
		int eDay = 26; //일
		
		//계산
		int start = (sYear * 10000) + (sMonth * 100) + sDay; //시작
		int startYear = start / 10000; //시작하는 연도
		int startMonth = (start / 100 ) - (startYear * 100); //시작하는 달
		int startDay = start % 100; //시작하는 날
		System.out.println("시작일 : " + startYear + "년 " + startMonth + "월 " + startDay + "일");
		
		int end = (eYear * 10000) + (eMonth * 100) + eDay; //끝
		int endYear = end / 10000; //끝나는 연도
		int endMonth = (end / 100) - (endYear * 100); //끝나는 달
		int endDay = end % 100; //끝나는 날
		System.out.println("종료일 : " + endYear + "년 " + endMonth + "월 " + endDay + "일");
		
		int diffYear = endYear - startYear; //차이 (년)
		int diffMonth = endMonth - startMonth; //차이 (달)
		
		
		int period = ( diffYear * 12 ) + diffMonth; //총 차이 (달)
		int period2 = period - 1;
		double finalRate2 = Math.pow (interestRate2, period2);
		double finalRate = Math.pow (interestRate2, period);
		
		
		//결과
		if (startDay > endDay) {
			double finalMoney = amout * finalRate2;
			int finalMoney2 = (int) finalMoney;
			System.out.println("총 금액 : " + finalMoney2 + "원" );
		}else {
			double finalMoney = amout * finalRate;
			int finalMoney2 = (int) finalMoney;
			System.out.println("총 금액 : " + finalMoney2 + "원" );
		}
		 
		 
	}

}
