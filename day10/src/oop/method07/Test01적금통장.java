package oop.method07;

public class Test01적금통장 {

	public static void main(String[] args) {

		Bank a = new Bank();
		Bank b = new Bank();
		Bank c = new Bank();
		
		a.setting("유재석", 2.2, 1, 500000, 2);
		b.setting("강호동", 2.5, 1, 500000, 2);
		c.setting("신동엽", 2.35, 1.5, 600000, 3);
		
		a.info();
		b.info();
		c.info();
		
	}

}
