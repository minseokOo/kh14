package data02;

public class Test03BMI계산기 {

	public static void main(String[] args) {
		
		int height = 180;
		double mHeight = (double)height / 100;
		int weight = 80;
		double height2 = (double)mHeight * mHeight;
		
		double bmi = weight / height2;
		
		System.out.println("신장 " + height + "cm 몸무게 " + weight + "kg의 BMI지수는 " + bmi + "입니다.");
	}

}
