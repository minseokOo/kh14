package oop.inherit06;

public class Test01파일 {

	public static void main(String[] args) {
		
		Mp4 f1 = new Mp4();
		f1.setFileName("mp4");
		f1.setFileSize(50);
		f1.speed();
		f1.execute();
		f1.rewind();
		f1.forward();
		f1.information();
		System.out.println("-----------------------");
		
		Mp3 f2 = new Mp3();
		f2.setFileName("mp3");
		f2.setFileSize(30);
		f2.duration();
		f2.forward();
		f2.rewind();
		f2.execute();
		f2.information();
		System.out.println("-----------------------");
		
		Hwp f3 = new Hwp();
		f3.setFileName("hwp");
		f3.setFileSize(100);
		f3.execute();
		f3.pageSize();
		f3.preview();
		f3.information();
		System.out.println("-----------------------");
		
		Ppt f4 = new Ppt();
		f4.setFileName("ppt");
		f4.setFileSize(70);
		f4.execute();
		f4.pageSize();
		f4.slideShow();
		f4.information();
		
		
	}
}
