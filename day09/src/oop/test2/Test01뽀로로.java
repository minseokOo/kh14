package oop.test2;

public class Test01뽀로로 {

	public static void main(String[] args) {

		Student pororo = new Student();
		
		pororo.character = "뽀로로";
		pororo.grade = 1;
		pororo.score = 75;

		System.out.println(pororo.character);
		System.out.println(pororo.grade);
		System.out.println(pororo.score);
		
		Student crong = new Student();
		
		crong.character = "크롱";
		crong.grade = 1;
		crong.score = 50;
		
		System.out.println(crong.character);
		System.out.println(crong.grade);
		System.out.println(crong.score);
		
		Student poby = new Student();
		
		poby.character = "포비";
		poby.grade = 2;
		poby.score = 86;
		
		System.out.println(poby.character);
		System.out.println(poby.grade);
		System.out.println(poby.score);
		
		Student harry = new Student();
		harry.character = "해리";
		harry.grade = 2;
		harry.score = 77;
		
		System.out.println(harry.character);
		System.out.println(harry.grade);
		System.out.println(harry.score);
		
	}

}
