package oop.total1;

public class Time {

	private int value;
	private int time;
	private int minute;
	private int second;
	
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		if(time < 0) return;
		this.time = time;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0) return;
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0) return;
		this.second = second;
	}
	public Time(int second) {
		this(0, 0, second);
	}
	
	public Time(int minute, int second) {
		this(0, minute, second);
	}
	public Time(int time, int minute, int second) {
		this.time = time;
		this.minute = minute;
		this.second = second;
	}
	
	public int getTotal() {
		return this.getTime() * 3600 + this.getMinute() *60 + this.getSecond();
	}
	
	public int getTime2() {
		return getTotal() / 3600;
	}
	public int getMinute2() {
		return getTotal() % 3600 / 60;
	}
	public int getSecond2() {
		return getTotal() %60;
	}
	
	public void info() {
		//System.out.println(getTotal() + "초");
		System.out.println(getTime2() + "시간 " + getMinute2() + "분 " + getSecond2() + "초");
		System.out.println();
	}
	
}
