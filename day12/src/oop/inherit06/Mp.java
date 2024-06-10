package oop.inherit06;

public class Mp extends File{

	
	public void forward() {
		System.out.println("빨리 감기");
	}
	public Mp(String filename, long filesize) {
		super(filename, filesize);
	}
	public Mp(String filename) {
		super(filename);
	}
	public void rewind() {
		System.out.println("되감기");
	}
}
