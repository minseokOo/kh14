package oop.constructor3;

public class Game {

	private String name;
	private String job;
	private int level;
	private int gold;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		switch (job) {
		case "전사": case "도적": case "마법사":
			this.job = job;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level < 1)
			return;
		this.level = level;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		if (gold < 0)
			return;
		this.gold = gold;
	}

	public Game(String name, String job) {
		this.setName(name);
		this.setJob(job);
		this.setLevel(1);
		this.setGold(100);
	}
	
//	public Game(String name, String job, int level, int gold) {
//		this.name = name;
//		this.job = job;
//		this.level = level;
//		this.gold = gold;
//
//	}

	public void info() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : " + this.getName());
		System.out.println("직   업 : " + this.getJob());
		System.out.println("레   벨 : " + this.getLevel());
		System.out.println("소지금 : " + this.getGold());
	}

}
