package data;

public class Test07주차장계산기 {

	public static void main(String[] args) {
		
		int hour = 60;
		int hour1 = 12;
		int min1 = 40;
		int hour2 = 15;
		int min2 = 10;
		
		// (1) 이 차량의 주차 시간을 구하여 화면에 출력하시오
			int totalHour = (hour2 - hour1);
			int totalMin = (min2 - min1);
			int totalMin2 = (totalHour * hour + totalMin ); //분 단위로 변환한 총 값
			int finalHour = (totalMin2 / hour);
			int finalMin = (totalMin2 % hour);
			
			System.out.println("주차 시간은 " + finalHour + "시간 " + finalMin + "분 입니다.");
			
			System.out.println( );
		// (2) 이 차량의 주차 요금을 구하여 화면에 출력하시오.
			int price = 1000; //요금
			int mintime = 10; //주기 (분)
			int totalPrice = ((totalMin2 / mintime) * price);
			
			System.out.println("총 요금은 " + totalPrice + "원 입니다.");
					
	}

}
