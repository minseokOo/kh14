package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test04시간변경 {
	public static void main(String[] args) {
		//Calendar 를 Date 처럼 형식에 맞게 출력 할 수 있을까?
		// -> Calendar 정보를 Date 객체로 변환하여 사용
		
		Calendar c = Calendar.getInstance();

		//시간 변경
		//c.setYear(2000);
//		c.set(Calendar.YEAR, 2000);
//		c.set(Calendar.MONTH, 0); //month 는 0부터 시작
//		c.set(Calendar.DATE, 1);
		c.set(2000, 0, 1);
		
		c.add(Calendar.MONTH, 18); // 18개월 후
		
		//Date 로 변환
		Date d = c.getTime();
		SimpleDateFormat fmt = 
				new SimpleDateFormat("y년 M월 d일 E h시 m분 s초");
		
		System.out.println(fmt.format(d));
		
	}
}
