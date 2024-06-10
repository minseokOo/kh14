package oop.inherit06;

public class Hwp extends HwpPpt {

	public Hwp(String filename, int pagesize) {
		super(filename, pagesize);
	}

	public Hwp(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public Hwp(String filename) {
		super(filename);
	}

	public void preview() {
		System.out.println(this.fileName + "파일을 미리보기 합니다.");
	}
	
}
