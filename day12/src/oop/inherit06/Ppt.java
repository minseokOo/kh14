package oop.inherit06;

public class Ppt extends HwpPpt {

	public Ppt(String filename, int pagesize) {
		super(filename, pagesize);
	}

	public Ppt(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public Ppt(String filename) {
		super(filename);
	}

	public void slideShow() {
		System.out.println("슬라이드 쇼");
	}
}
