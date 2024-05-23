package data;

public class Test10편의점행사상품 {

	public static void main(String[] args) {

		int price = 1500; //삼각 김밥 가격
		int totalGb = 5; //삼각 김밥 구매 갯수
		int totalPay = (totalGb / 2) + (totalGb % 2); //행사시 계산해야 하는 갯수
		
		int totalPrice = totalPay * price;
		
		System.out.println("삼각김밥 " + totalGb + "개의 금액은 " + totalPrice + "원 입니다.");
		
		int freeGb = totalGb / 2;
		
		System.out.println("무료로 계산되는 삼각김밥은 " + freeGb + "개 입니다.");
	}

}
