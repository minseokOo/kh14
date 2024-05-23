package data;

public class Test11커피숍계산기 {

	public static void main(String[] args) {
		
		//- 아메리카노 한 잔 = 2000, (5+1)
		//- 카페모카 한잔 = 2500 (4+1)
		//우리 반 학생 27명에 강사 포함 28명을 조사했더니 아메리카노 14잔,
		//카페모카 14잔으로 조사되었습니다.
		//- 무료로 처리된 아메리카노와 카페모카 잔 수를 각각 출력
		//-아메리카노 금액과 카페모카 금액을 출력
		//총 금액을 출력
		
		int ame = 2000; //아메리카노 가격
		int mocca = 2500; //카페모카 가격
		int totalAme = 14; //아메리카노 개수
		int totalMocca = 14; //카페모카 개수
		
		int freeAme = totalAme / 6;
		int pAme = totalAme - freeAme;
		int freeMocca = totalMocca / 5;
		int pMocca = totalMocca - freeMocca;
		
		System.out.println("무료로 처리된 아메리카노는 " + freeAme + "잔이고, 무료 카페모카는 " + freeMocca + "잔 입니다.");
		
		int totalPriceAme = pAme * 2000;
		int totalPriceMocca = pMocca * 2500;
		
		System.out.println("아메리카노의 총 가격은 " + totalPriceAme + "원이고, 카페모카의 총 가격은 " + totalPriceMocca + "원 입니다.");
		
		int totalPrice = totalPriceAme + totalPriceMocca;
		
		System.out.println("커피의 총 가격은 " + totalPrice + "원 입니다.");
	}

}
