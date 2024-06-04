package oop.method05;

public class Test01메소드분할 {

	public static void main(String[] args) {
		
		Student stu = new Student();
		
		stu.setting("마리오", 50);
		stu.info();
		
		stu.setName("피카츄"); //이름만 변경
		stu.info();
		
		stu.setScore(70); //점수만 변경
		stu.info();
		
		
		
	}
}
