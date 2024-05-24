package data03;

public class Test05건강검진대상자판정3 {

	public static void main(String[] args) {

        int todayInt = 20240524;
        
		int birth = 19880825;
		int age = todayInt / 10000 - birth / 10000;
		int yearNow = todayInt / 10000;
		
		System.out.println(age);
		System.out.println(yearNow);
		
		boolean a = ( age + yearNow ) % 2 == 0;
		
		System.out.println(a);
		
		
		
		
	}

}
