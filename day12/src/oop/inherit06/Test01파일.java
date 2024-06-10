package oop.inherit06;

public class Test01파일 {

	public static void main(String[] args) {
		
		Mp4 f1 = new Mp4("자바의 정석.mp4", 102400L);
		f1.execute();
		f1.rewind();
		f1.forward();
		f1.information();
		System.out.println("-----------------------");
		
		Mp3 f2 = new Mp3("수면 장작 소리.mp3", 12314L, 3*60*60);
		f2.forward();
		f2.rewind();
		f2.execute();
		f2.information();
		System.out.println("-----------------------");
		
		Hwp f3 = new Hwp("자바 정리노트.hwp", 123123L, 30);
		f3.execute();
		f3.preview();
		f3.information();
		System.out.println("-----------------------");
		
		Ppt f4 = new Ppt("발표자료.ppt", 12314L, 30);
		f4.execute();
		f4.slideShow();
		f4.information();
		
		
	}
}
