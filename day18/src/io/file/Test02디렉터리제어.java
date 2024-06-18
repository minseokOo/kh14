package io.file;

import java.io.File;

public class Test02디렉터리제어 {
	public static void main(String[] args) {
		
		File dir = new File("./sample");
		System.out.println("존재 : " + dir.exists());
		
		//디렉터리 생성
		//dir.mkdir(); // 경로에 빠진게 있으면 생성 불가
		dir.mkdirs(); // 경로에 없는 파일을 생성하면서 파일 생성
		
		System.out.println("크기 : " + dir.length());
		
		// 디렉터리는 안에 있는 파일 모두 꺼낼 수 있는 명령이 있다.
		// - 이름만 꺼낼 때는 .list() , 파일을 꺼낼 때는 .listFiles()
		
		String[] names = dir.list();
		for(int i=0; i < names.length; i++) {
		System.out.println(names[i]);
		
		}

		File[] files = dir.listFiles();
		for(File f : files) {
			System.out.println(f.getAbsolutePath());
			System.out.println(f.length());
		}
	}
}
