package oop.inherit03;

public class Test01브라우저상속 {

	public static void main(String[] args) {
		
		Chrome c1 = new Chrome();
		c1.save();
		c1.refresh();
		c1.move();
		c1.develop();
		c1.store();
		System.out.println("--------------------");
		
		Edge e1 = new Edge();
		e1.save();
		e1.refresh();
		e1.move();
		e1.fullScreen();
		System.out.println("--------------------");
		
		Whale w1 = new Whale();
		w1.save();
		w1.refresh();
		w1.move();
		w1.translate();
		w1.naver();
		
		
	}
}
