package api.file.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test04문자열입력 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("files", "string2.kh");
		
		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr); //\n 전까지 모으는 역할
		
		while(true) {
		String line = br.readLine(); //한 줄을 읽어서 저장
		if(line == null) break; //EOF == null
		System.out.println("line = " + line);
		}
		
		br.close();
	}
}
