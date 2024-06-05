package oop.method03;

public class Test01카페메뉴 {

	public static void main(String[] args) {
		
		cafe ame = new cafe();
		cafe moca = new cafe();
		cafe cake = new cafe();
		cafe maca = new cafe();
		
		ame.setting("아메리카노", "음료", 2500, true); //4개짜리 setting
		moca.setting("모카라떼", "음료", 3500); //3개짜리 setting
		cake.setting("치즈케이크", "디저트", 5000, true);
		maca.setting("마카롱", "디저트", 3000);
		
		
		ame.info();
		moca.info();
		cake.info();
		maca.info();
		
		
		
	}
}
