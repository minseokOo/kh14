package oop.method06;

public class Test01학생성적정보 {

	public static void main(String[] args) {
		
		Student a = new Student();
		Student b = new Student();
		Student c = new Student();
		Student d = new Student();
		
		a.setting("뽀로로", 1, 35, 80, 80);
		b.setting("루피", 1, 50, 60, 70);
		c.setting("크롱", 2, 60, 60, 70);
		d.setting("포비", 2, 90, 20, 80);
		
		a.info();
		b.info();
		c.info();
		d.info();
		
		
	}
}
