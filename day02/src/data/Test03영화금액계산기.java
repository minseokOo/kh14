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
		
		System.out.println("성인요금");
		System.out.println(adult);
		System.out.println("학생요금");
		System.out.println(student);
		System.out.println( );
		System.out.println("성인요금합계");
		System.out.println(adultTotal);
		System.out.println( );
		System.out.println("학생요금합계");
		System.out.println(studentTotal);
		System.out.println( );
		System.out.println("총 요금");
		System.out.println(total);
		
	}

}
