package oop.inherit06;

public class File {

	protected String fileName;
	protected long fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		if (fileSize < 0) return;
		this.fileSize = fileSize;
	}
	
	public void execute() {
		System.out.println("실행");
	}
	public void information() {
		System.out.println("정보 출력");
	}

}
