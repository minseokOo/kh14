package oop.method02;

public class olympic {

	String name;
	String type;
	String season;
	int golden;
	int silver;
	int bronze;
	
	
	void setting(String name, String type, String season, int golden, int silver, int bronze) {
		this.name= name;
		this.type = type;
		this.season = season;
		this.golden = golden;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	void info() {
		System.out.println(name);
		System.out.println(type);
		System.out.println(season);
		System.out.println("금메달 " + golden + "개, 은메달 " + silver + "개, 동메달 " + bronze + "개" );
		System.out.println("메달 합계 : " + (golden + silver + bronze) + "개");
		System.out.println("---------------------");
	}
}
