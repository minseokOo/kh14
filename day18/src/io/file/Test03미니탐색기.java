package io.file;

import java.io.File;
import java.util.Scanner;

public class Test03미니탐색기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		File a = new File(input);
		String aName = a.getName();
		String dot = aName.substring(aName.lastIndexOf(".") + 1);
		
		 if (!a.exists()) {
			System.out.println("존재하지 않는 파일 또는 폴더");
		}
		
		 else if (a.isFile()) {
			System.out.println("파일 입니다.");
			System.out.println("파일 이름 : " + aName);
			System.out.println("파일 유형 : " + dot);
			System.out.println("파일 크기 : " + a.length());
		} 
		 else if (a.isDirectory()) {
			System.out.println("디렉토리 입니다.");
			//System.out.println(a.getPath());

			String[] fileNames = a.list();
			for (int i = 0; i < fileNames.length; i++) {
				if(!fileNames[i].contains(".")) {
					System.out.println(fileNames[i] + "[폴더]" );}
				else if (fileNames[i].contains(".")) {
					System.out.println(fileNames[i] + "[파일]" );
				}
			}
		}

	}
}
