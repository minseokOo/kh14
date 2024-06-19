package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test05싱글바이트대용량입력 {
	public static void main(String[] args) throws IOException {
		// 준비물
		// (1) 제어용 파일 객체
		File input = new File("sample", "single2.txt");
		
		// (2) 입력용 통로 객체
		FileInputStream stream = new FileInputStream(input);
		
		byte[] data = new byte[5];
		
		while(true) {
			int size = stream.read(data);
			if(size == -1)break;
			System.out.println("size = " + size + ", " + Arrays.toString(data));
		}
		
		stream.close();
	}
}
