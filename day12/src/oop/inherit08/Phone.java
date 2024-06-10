package oop.inherit08;

public abstract class Phone {

	private String name;
	private String numberData;
	private String color;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumberData() {
		return numberData;
	}
	public void setNumberData(String numberData) {
		this.numberData = numberData;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void show() {
		System.out.println("<스마트폰 정보>");
		System.out.println("전화번호 : " + this.numberData);
		System.out.println("색상 : " + this.color);
	}
	
	public Phone(String name, String numberData, String color) {
		this.setName(name);
		this.setNumberData(numberData);
		this.setColor(color);
	}
	
	public abstract void call();
	public abstract void sms();
	
}
