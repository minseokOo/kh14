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
		
		System.out.println(adult);
		System.out.println(student);
		System.out.println(adultTotal);
		System.out.println(studentTotal);
		System.out.println(total);
		
	}

}
