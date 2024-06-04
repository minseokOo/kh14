package oop.method02;

public class Test01메소드활용문제 {

	public static void main(String[] args) {
		
		olympic a = new olympic();
		olympic b = new olympic();
		olympic c = new olympic();
		
		a.setting("진종오", "사격", "하계", 4, 2, 0);
		b.setting("김수녕", "양궁", "하계", 4, 1, 1);
		c.setting("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		a.info();
		b.info();
		c.info();
	}
}
