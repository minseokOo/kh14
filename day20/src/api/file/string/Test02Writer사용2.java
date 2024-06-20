package api.file.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test02Writer사용2 {
	public static void main(String[] args) throws IOException {
		// FileWriter에 두 개의 보조 스트림을 추가하여 사용
		// BufferedWriter - 버퍼의 크기를 조절할 수  있는 외장 버퍼
		// PrintWriter - 숫자출력이나 엔터 자동추가 등을 처리
		
		File target = new File("files", "string3.kh");
//		FileOutputStream stream = new FileOutputStream(target);
		FileWriter fw = new FileWriter(target);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("안녕 자바!");
		pw.println("반가워!");
		pw.print("뻥");
		pw.print("이");
		pw.print("야!");
		pw.println();
		pw.println(100);
		
		
		pw.close();
		
	}
}
