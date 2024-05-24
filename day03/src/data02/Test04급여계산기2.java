package data02;

public class Test04급여계산기2 {

	public static void main(String[] args) {

		int money = 3000000; //급여
		double gmyg = 4.5; //국민연금
		double ggbh = 7.09; //건강보험료
		double gmyg2 = gmyg / 100;
		double ggbh2 = ggbh / 100;
		
		double gmygP = money * gmyg2; //국민연금 납부액
		double ggbhP = money * ggbh2; //건강보험 납부액
		
		double yybh = 12.81; //요양보험
		double gybh = 0.9; //고용보험
		double yybh2 = yybh / 100;
		double gybh2 = gybh / 100;
		
		double yybhP = ggbhP * yybh2; //요양보험 납부액
		double gybhP = money * gybh2; //고용보험 납부액
		
		
		
		double gmygg = Math.round(gmygP); //소수점 반올림
		double ggbhg = Math.round(ggbhP);
		double yybhg = Math.round(yybhP);
		double gybhg = Math.round(gybhP);
		
		
		int a = (int) (gmygg); //형변환 double to int
		int b = (int) (ggbhg); 
		int c = (int) (yybhg);
		int d = (int) (gybhg);
		
		int total = a + b + c + d;
		int finMoney = money - total;		
		System.out.println("급여 : " + money + "원");
		System.out.println("-----------------------------------");
		System.out.println("국민연금 납부 금액 : " + a + "원");
		System.out.println("건강보험 납부 금액 : " + b + "원");
		System.out.println("요양보험 납부 금액 : " + c + "원");
		System.out.println("고용보험 납부 금액 : " + d + "원");
		System.out.println("-----------------------------------");
		System.out.println("총 납부 금액 : " + total + "원");
		System.out.println("-----------------------------------");
		System.out.println("실 급여 : " + finMoney + "원");
		
		
	}

}
