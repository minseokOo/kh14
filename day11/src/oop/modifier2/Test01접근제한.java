package oop.modifier2;

import oop.modifier1.Student;

public class Test01접근제한 {

	public static void main(String[] args) {
		
		Student st1 = new Student();
		
		st1.setting("피카츄", 77);
//		st1.setScore(101);
//		st1.score = 500;
		st1.info();
	}
}
