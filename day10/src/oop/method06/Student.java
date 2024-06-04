package oop.method06;

public class Student {

	String name;
	int grade;
	int korean;
	int english;
	int math;
	int total;
	int avg;
	
	void setName(String name) {
		this.name = name;
	}
	
	void setGrade(int grade) {
		if(grade>=1 && grade<=3) {
			this.grade = grade;
		}
	}
	
	void setKorean(int korean) {
		if(korean>=0 && korean <= 100) {
			this.korean = korean;
		}
	}
	
	void setEnglish(int english) {
		if(english>=0 && english <= 100) {
			this.english = english;
		}
	}
	
	void setMath(int math) {
		if(math>=0 && math <= 100) {
			this.math = math;
		}
	}
	void setTotal(int total) {
		this.total = total;
	}
	void setAvg(int avg) {
		this.avg = avg;
	}
	
	void setting(String name, int grade, int korean, int english, int math) {
		this.setName(name);
		this.setGrade(grade);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	String getName() {
		return this.name;
	}
	int getGrade() {
		return this.grade;
	}
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getMath() {
		return this.math;
	}
	int getTotal() {
		return (this.korean + this.english + this.math);
	}
	double getAvg() {
		return (getTotal()/3d);
	}
	String getPass() {
		if(this.korean>=40 && this.english >=40 
				&& this.math >=40 && this.getAvg() >=60) {
			return "합격";
		}
		else {
			return "불합격";
		}
	}
	
	void info() {
		System.out.println("<학생 성적 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("학년 : " + this.getGrade());
		System.out.println("국어 점수 : " + this.getKorean());
		System.out.println("영어 점수 : " + this.getEnglish());
		System.out.println("수학 점수 : " + this.getMath());
		System.out.println("총점 : " + this.getTotal());
		System.out.println("평균 : " + this.getAvg());
		System.out.println(this.getPass());
		
	}
	
}
