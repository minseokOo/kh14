package api.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test10포커게임 {
	public static void main(String[] args) {
		
		List<String> shapes = List.of("하트", "클로버", "스페이드", "다이아");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
	
		List<String> deck = new ArrayList<>();
		for(int i=0; i < shapes.size(); i++) {
			for(int k=0; k < numbers.size(); k++){
				String card = shapes.get(i) + " " + numbers.get(k);
				deck.add(card);
			}
		}
		//System.out.println(deck);
		System.out.println("덱 생성이 완료되었습니다.");
		
		Collections.shuffle(deck);
		System.out.println("덱이 랜덤으로 섞였습니다.");
		List<String> player1 = new ArrayList<>();
		List<String> player2 = new ArrayList<>();
		List<String> player3 = new ArrayList<>();
		List<String> player4 = new ArrayList<>();
	
		
		for(int i=0; i<6; i++) {
			
		String card = deck.get(0);
		player1.add(card);
		deck.remove(0);
		
		card = deck.get(0);
		player2.add(card);
		deck.remove(0);
		
		card = deck.get(0);
		player3.add(card);
		deck.remove(0);
		
		card = deck.get(0);
		player4.add(card);
		deck.remove(0);
		}
		
		System.out.println("player1 = " + player1);
		System.out.println("player2 = " + player2);
		System.out.println("player3 = " + player3);
		System.out.println("player4 = " + player4);
		
	}
}
