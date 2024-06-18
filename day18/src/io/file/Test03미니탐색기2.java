package io.file;

import java.io.File;
import java.util.Scanner;

public class Test03미니탐색기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String input = sc.nextLine();
		sc.close();

		File target = new File(input);

		if(!target.exists()) {//존재하지 않는다면
			System.out.println("존재하지 않는 대상");
		}
		else if(target.isFile()) {
			System.out.println("파일명 : " + target.getName());

			//파일 중에는 확장자가 없는 파일도 있다
			int position = target.getName().lastIndexOf(".");//없으면 -1
			String extension;
			if(position == -1) {//점(.)이 없으면
				extension = "없음";
			}
			else {
				extension = target.getName().substring(position);
			}

			System.out.println("확장자 : " + extension);
			System.out.println("크기 : "+target.length()+" bytes");
		}
		else {//target.isDirectory()
			File[] list = target.listFiles();
			for(File f : list) {
				System.out.print(f.getName());
				System.out.print(" ");
				if(f.isFile()) {
					System.out.print("[파일]");
				}
				else if(f.isDirectory()) {
					System.out.print("[폴더]");
				}
				System.out.println();
			}
		}

	}
}