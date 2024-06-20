package api.file.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test03콘솔메모장 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		File dir = new File("files");
		File target = new File("./files", "notepad.kh");
		File temp = File.createTempFile("notepad", ".kh", dir); //임시파일
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(temp)));
		
		while(true) {
			String input = sc.nextLine();
			if(input.equals("종료"))
				break;
			
			else{
			pw.println(input);
			pw.flush();
			}
		}
		sc.close();
		pw.close();
		
		FileInputStream in = new FileInputStream(temp);
		FileOutputStream out = new FileOutputStream(target);
		byte[] buffer = new byte[8192];
		while(true) {
			int size = in.read(buffer);
			if(size == -1) break;
			out.write(buffer, 0, size);
		}
		in.close();
		out.close();
		
		temp.delete();
	}
}
