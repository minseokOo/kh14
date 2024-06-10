package oop.inherit06;

public class File {

	protected String fileName;
	private long fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public File(String filename) {
		this(filename, 0L);
	}
	public File(String filename, long filesize) {
		this.setFileName(filename);
		this.setFileSize(filesize);
	}
	
	public void execute() {
		System.out.println(this.getFileName() + "실행");
	}
	public void information() {
		System.out.println("정보 출력");
	}

}
