package oop.inherit06;

public class HwpPpt extends File {

	private int pagesize;
	
	public void setPagesize(int pagesize) {
		if(pagesize < 1) return;
		this.pagesize = pagesize;
	}
	public int getPagesize() {
		return pagesize;
	}
	
	public HwpPpt(String filename, long filesize, int pagesize) {
		super(filename, filesize);
		this.setPagesize(pagesize);
	}

	public HwpPpt(String filename, int pagesize) {
		super(filename);
		this.setPagesize(pagesize);
	}
	public HwpPpt(String filename) {
		super(filename);
		this.setPagesize(1);
	}

	
}
