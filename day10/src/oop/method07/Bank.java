package oop.method07;

public class Bank {

	String name;
	double rate;
	double plusRate;
	int monthly;
	int yearCount;
	
	void setName(String name) {
		this.name=name;
	}
	void setRate(double rate) {
		this.rate=rate;
	}
	void setPlusRate(double plusRate) {
		this.plusRate=plusRate;
	}
	void setMonthly(int monthly) {
		this.monthly=monthly;
	}
	void setYearCount(int yearCount) {
		this.yearCount=yearCount;
	}
	
	void setting(String name, double rate, double plusRate, int monthly, int yearCount) {
		this.setName(name);
		this.setRate(rate);
		this.setPlusRate(plusRate);
		this.setMonthly(monthly);
		this.setYearCount(yearCount);
	}
	
	String getName(){
		return this.name;
	}
	double getRate() {
		return this.rate;
	}
	double getPlusRate() {
		return this.plusRate;
	}
	int getMonthly() {
		return this.monthly;
	}
	int getYearCount() {
		return this.yearCount;
	}
	
	double getTotalRate() {
		return this.rate + this.plusRate;
	}
	int getYearTotal() {//1년 예금 금액
		return this.monthly * 12;
	}
	int getTotalMoney() {
		return getYearTotal() * getYearCount();
	}
	double getFinal() {
		return getYearTotal() * getYearCount() * (1+getTotalRate()/100);
	}
	int getFinal2() {
		return (int) getFinal();
	}
	
	void info() {
		System.out.println("<적금 통장 정보");
		System.out.println("예금주 : " + this.getName());
		System.out.println("기본 이율 : " + this.getRate());
		System.out.println("우대 이율 : " + this.getPlusRate());
		System.out.println("총 합 이율 : " + this.getTotalRate());
		System.out.println("월 부금 : " + this.getMonthly());
		System.out.println("1년 예금 금액 : " + this.getYearTotal());
		System.out.println("총 예금 금액 : " + this.getTotalMoney());
		System.out.println("예치 기간(년) : " + this.getYearCount());
		System.out.println("만기 예상 금액 : " + this.getFinal2());
		if(this.getYearCount() < 3) {
			System.out.println("비과세 상품");
		}
		else {
			System.out.println("과세 상품");
		}
	}
	
}
