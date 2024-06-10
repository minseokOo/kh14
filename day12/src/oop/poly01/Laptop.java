package oop.poly01;

public class Laptop {

	private String name;
	private String use;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		switch(name) {
		case "맥북" : case "갤럭시북":
		}
		this.name = name;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		switch(use) {
		case "전원" : case "동영상재생" : case "타이핑" :
		}
		this.use = use;
	}
	
	public Laptop(String name, String use) {
		this.setName(name);
		this.setUse(use);
	}
	public void show(){
		System.out.println(this.getName() + "으로 " + this.getUse() + "를(을) 합니다.");
	}
	
}
