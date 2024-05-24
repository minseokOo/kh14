package data02;

public class Test05PC방계산기 {

	public static void main(String[] args) {

		//입력
		int hourPrice = 1000; //시간당 요금
		int startTimeHour = 12; //시작 시간
		int startTimeMinute = 20;
		int startTime = startTimeHour * 60 + startTimeMinute;
		int endTimeHour = 15; //끝나는 시간
		int endTimeMinute = 30;
		int endTime = endTimeHour * 60 + endTimeMinute;
		
		//계산
		int usedTime = endTime - startTime; //이용 시간
		
		double minutePrice = (double) hourPrice / 60; //분당 요금
		
		double finPrice = usedTime * minutePrice; //최종 가격 (double)
		
		int aFinPrice = (int)finPrice; //최종 가격 (int)
		
		int bFinPrice = ( aFinPrice / 10 ) * 10; //최종 가격
		
		int time = usedTime / 60; //이용시간
		int minute = usedTime % 60;
		
		System.out.println("총 이용 시간은 " + time + "시간 " + minute + "분 입니다.");
		System.out.println("피시방 사용 요금은 " + bFinPrice + "원 입니다.");
		
	}

}
