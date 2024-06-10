package oop.inherit06;

public class Mp3 extends Mp {

	public int duration;
	
	public void setDuration(int duration) {
		if(duration < 0 ) return;
		this.duration = duration;
	}
	public int getDuration() {
		return duration;
	}
	public Mp3(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.setDuration(duration);
	}
	public Mp3(String filename, int duration) {
		super(filename);
		this.setDuration(duration);
	}
	
	
}
