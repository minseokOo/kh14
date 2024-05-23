package data;

public class Test04술집계산기 {

	public static void main(String[] args) {

		//입력
		int soju = 5000;
		int beer = 6000;
		int cola = 2000;
		int sojuCount = 2;
		int beerCount = 3;
		int colaCount = 1;
		
		//계산
		int sojuTotal = (soju * sojuCount);
		int beerTotal = (beer * beerCount);
		int colaTotal = (cola * colaCount);
		int totalPrice = (sojuTotal + beerTotal + colaTotal);
		
		
		//출력
		System.out.println("소주 " + sojuCount + "병 가격은 " + sojuTotal + "원 입니다.");
		System.out.println("맥주 " + beerCount + "병 가격은 " + beerTotal + "원 입니다.");
		System.out.println("콜라 " +colaCount + "병 가격은 " + colaTotal + "원 입니다.");
		System.out.println( );
		System.out.println("총 금액은 " + totalPrice + "원 입니다.");
	}

}
