package data02;

public class Test04급여계산기 {

	public static void main(String[] args) {

		int money = 3000000; //급여
		double gmyg = 0.045; //국민연금
		double ggbh = 0.0709; //건강보험료
		
		double gmygP = money * gmyg; //국민연금 납부액
		double ggbhP = money * ggbh; //건강보험 납부액
		
		double yybh = 0.1281; //요양보험
		double gybh = 0.009; //고용보험
		double yybhP = ggbhP * yybh; //요양보험 납부액
		double gybhP = money * gybh; //고용보험 납부액
		
		
		
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
