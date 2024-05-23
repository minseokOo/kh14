package data;

public class day0523 {

	public static void main(String[] args) {
		int icecream = 500;
		int candy = 200;
		int iceCount = 3;
		int candyCount = 5;
		
		
		int iceTotal = (icecream * iceCount);
		int candyTotal = (candy * candyCount);
		int total = (iceTotal + candyTotal);
		
		System.out.println("아이스크림 가격은 " + icecream + "원");
		System.out.println("사탕 가격은 " + candy + "원");
		System.out.println("아이스크림 " + iceCount + "개의 가격은" + iceTotal + "원");
		System.out.println("사탕 " + candyCount + "개의 가격은" + candyTotal + "원");
		System.out.println("아이스크림과 사탕 가격의 총 합은 " + total + "원");
		

	}

}
