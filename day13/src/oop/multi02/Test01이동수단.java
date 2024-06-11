package oop.multi02;

public class Test01이동수단 {

	public static void main(String[] args) {
		
		Drone t1 = new Drone();
		t1.power();
		t1.move();
		t1.fly();
		System.out.println();
		
		Airplane t2 = new Airplane();
		t2.move();
		t2.fly();
		t2.reservation();
		System.out.println();
		
		Train t3 = new Train();
		t3.move();
		t3.reservation();
		System.out.println();
		
		Bus t4 = new Bus();
		t4.move();
		System.out.println();
		
		KickBoard t5 = new KickBoard();
		t5.power();
		t5.move();
		
	}
}
