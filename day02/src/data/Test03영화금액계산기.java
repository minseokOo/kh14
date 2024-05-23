package data;

public class Test03영화금액계산기 {

	public static void main(String[] args) {
		
		int adult = 15000;
		int student = 8000;
		int adultCount = 2;
		int studentCount = 4;
		
		int adultTotal = (adult * adultCount);
		int studentTotal = (student * studentCount);
		int total = (adultTotal + studentTotal);
		

		System.out.println("성인요금 : " + adult + "원");
		System.out.println("학생요금 : " + student + "원");
		System.out.println( );
		System.out.println("성인요금합계 : " + adultTotal + "원");
		System.out.println( );
		System.out.println("학생요금합계 : " + studentTotal + "원");
		System.out.println( );
		System.out.println("총 요금 : " + total + "원");
		
	}

}
