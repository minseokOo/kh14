package condition;

import java.util.Scanner;

public class Test06여행사프로모션2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int oneDay = 100000; //요금
		System.out.println("여행가는 달을 입력하세요.");
		int month = sc.nextInt(); //가는 달
		System.out.println("인원 수를 입력하세요.");
		int guest = sc.nextInt(); //인원수
		System.out.println("여행 기간(일)을 입력하세요.");
		int day = sc.nextInt(); //기간
		
		
		int springDiscount = 20; //봄 할인율(%)
		float spDiscount = ((float) (100 - springDiscount) / 100);
		int summerDiscount = 10; //여름
		float sumDiscount = ((float) (100 - summerDiscount) / 100);
		int fallDiscount = 30; //가을
		float fDiscount = ((float) (100 - fallDiscount) / 100);
		int winterDiscount = 5; //겨울
		float wDiscount = ((float) (100 - winterDiscount) / 100);
		
		float price;
		System.out.print("할인율은 ");
		if (month >= 12|| month<3) {
			System.out.print(winterDiscount);
			price = oneDay * wDiscount;}
		else if (month >= 9) {
			System.out.print(fallDiscount);
			price = oneDay * fDiscount;}
		else if (month >= 6) {
			System.out.print(summerDiscount);
			price = oneDay * sumDiscount;}
		else {
			System.out.print(springDiscount);
			price = oneDay * spDiscount;
		}
		System.out.println("% 입니다.");
		int price2 = (int)price;
		System.out.println("할인가는 " + price2 + "원(일) 입니다.");
		int total = price2 * guest * day;
		
		System.out.println("총 요금은 " + total + "원 입니다.");
		
		
	}
}
