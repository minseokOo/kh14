package data03;

public class Test05건강검진대상자판정2 {

	public static void main(String[] args) {

        int todayInt = 20230524;
        
		int birth = 19880825;
		int age = todayInt / 10000 - birth / 10000;
		int yearNow = todayInt / 10000;
		
		System.out.println(age);
		System.out.println(yearNow);
		
		int evenAge = age % 2;
		boolean evAge = evenAge == 0; //짝수일때 트루
		int oddAge = age % 2;
		boolean oAge = oddAge == 1; //짝수일때 false
		boolean evYear = yearNow % 2 == 0; //짝수 년도일때 트루
		boolean oYear = yearNow % 2 ==1;
		
		boolean o = oAge == oYear;
		boolean e = evAge == evYear;
		
		boolean answer = o == e;
		
		System.out.println(answer);
		//트루 == 트루 : 트루, 트루 == false : false
		
		
		
		
		
	}

}
