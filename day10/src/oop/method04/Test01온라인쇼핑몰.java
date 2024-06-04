package oop.method04;

public class Test01온라인쇼핑몰 {

	public static void main(String[] args) {
		
		Item a = new Item();
		Item b = new Item();
		Item c = new Item();
		Item d = new Item();
		
		a.setting("비김면", "라면", 16800, 2, true);
		b.setting("크림대빵", "제과", 6500, 2, false);
		c.setting("점보도시락", "라면", 8500, 3, true, true, 5);
		d.setting("공간춘", "라면", 12300, 3, true, false, 20);
		
		
		a.info();
		b.info();
		c.info();
		d.info();
	}
	
}
