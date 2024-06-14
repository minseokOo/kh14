package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test06기념일계산기3 {
	public static void main(String[] args) {

		//int 배열에 3년 이하의 기념일을 채워라
		// -> int 배열에 365*3이하의 100의 배수와 365의 배수 기념일을 채워라
		int count = 0;
		for(int i =1; i <= 365 * 3; i++)
			if(i % 100 == 0 || i%365 == 0) {
				count++;
			}
		System.out.println("기념일 수 : " + count);
		
		int[] days = new int[count];
		int position = 0;
		for(int i=1; i<= 365 * 3; i+=100) {
			if(i % 100 == 0 || i % 365 == 0) {
				days[position] = i;
				position++;
			}
				
			}
		for(int i=365; i <= 365 * 3; i+=365) {
			days[position] = i;
			position++;
			
		}
		for(int i=0; i < days.length; i++) {
			System.out.println(days[i]);
		}
	}
}
