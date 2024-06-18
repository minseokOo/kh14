package io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01파일제어 {
	public static void main(String[] args) {
		// 파일
		// - 글자를 가지고 있는 저장 단위
		// - 파일의 크기는 파일에 들어 있는 글자 수
		// - 파일은 위치를 가지고 있으며 위치를 구분하는 단위가 디렉터리이다.
		// - 디렉터리는 파일을 구분하는 단위(카테고리 같은 것)
		// - 디렉터리는 크기가 없거나 최소한만 존재
		// - 같은 디렉터리 내에서는 동일한 이름의 파일이 두 개 있을 수 없다(대소문자 무관)
		// - 자바는 File 클래스로 파일과 디렉터리를 모두 제어
		
		// 객체 생성(파일을 만드는 것이 아님)
		File a = new File("D:/hello.txt");
		File b = new File("D:", "hello.txt");
		
		System.out.println(a.exists()); // 진짜 있는 파일인지
		System.out.println(a.isFile()); // 파일인가?		
		System.out.println(a.isDirectory()); // 디렉터리인가?
		
		System.out.println();
		
		System.out.println(a.getName()); //파일명 추출
		System.out.println(a.getPath()); //경로 추출(이름포함)
		System.out.println(a.length()); //파일 크기 (= 안에 있는 글자수, long)
		
		System.out.println();
		
		System.out.println(a.lastModified()); //최종 수정시각
		
		Date d = new Date(a.lastModified());
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E요일, a h:mm:ss");
		System.out.println(fmt.format(d));
	}
}
