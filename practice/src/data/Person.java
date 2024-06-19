package data;

public abstract class Person {
	
	private String name;
	private int age;
	private String job;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(!name.matches("^[가-힣]{1,2}[가-힣]{1,5}$")) 
			throw new IllegalArgumentException("이름은 한글로 2~7글자여야 합니다.");
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if(age < 1) {
			throw new IllegalArgumentException("나이는 0보다 커야합니다.");
			
		}
		this.age = age;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		if(!job.matches("^[가-힣A-Za-z0-9]+$")) return;
		this.job = job;
	}
	void setting(String name, int age) {
		this.setting(name, age, "무직");
	}
	
	void setting(String name, int age, String job) {
		this.setName(name);
		this.setAge(age);
		this.setJob(job);
	}
	void info() {
		System.out.println("<정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("직업 : " + this.job);
		if(age <= 7) {
			System.out.println("유아");
		}
		else if (age <=13) {
			System.out.println("어린이");
		}
		else if (age <=19) {
			System.out.println("청소년");
		}
		else {
				System.out.println("성인");
		}
	}
}
