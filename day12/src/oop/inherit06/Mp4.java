package oop.inherit06;

public class Mp4 extends Mp {

	private float speed = 1f;
	
	public void setSpeed(float speed) {
		if(speed <= 0f) return;
		this.speed = speed;
	}
	
	public float getSpeed() {
		return speed;
	}

	public Mp4(String filename, long filesize) {
		super(filename, filesize);
		//this.setSpeed(1f);
	}

	public Mp4(String filename) {
		super(filename);
		//this.setSpeed(1f);
	}
	
	
}
