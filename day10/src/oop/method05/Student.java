package oop.method05;

public class Student {

	String name;
	int score;
	
	//세터(setter) 메소드
	// - 각각의 변수 값을 변경하는 목적의 메소드
	// - set 과 필드명을 합쳐서 만든다
	// - name 에 대한 setter 메소드의 이름은? setName
	// - (중요) 조건을 추가하면 원치 않는 값을 필터링 할 수 있다.
	void setName(String name) {
		this.name = name;
	}
	void setScore(int score) {
		if(score >= 0 && score <= 100) {
		this.score = score;}
	}
	
	
	void setting(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	//게터(getter)메소드
	// - 필드의 값을 반환하기 위해서 사용
	// - get 과 필드명을 합쳐서 이름을 짓는다.
	// - return 키워드를 이용하여 값을 반환하며 그에 맞는 자료형을 작성해야함
	// - 이것을 반환 자료형(return type)이라고 부름
	// - (중요) 존재하지 않는 항목을 계산하여 반환하도록 만들 수 있다
	String getName() {
		return this.name;//주인공의 이름을 반환합니다
	}
	int getScore() {
		return this.score;
	}
	String getGrade() {
		if(this.score >= 90) {
			return "A";
		}
		else if(this.score >= 80) {
			return "B";
		}
		else if(this.score >= 70) {
			return "C";
		}
		else {
			return "F";
		}
	}
	
	void info() {
		System.out.println("<학생정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("점수 : " + this.getScore() + "점");
		System.out.println("학점 : " + this.getGrade());
		
	}
	
}
