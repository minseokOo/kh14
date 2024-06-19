package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사하기 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("sample", "single.txt");
		File copy = new File ("sample", "copy.txt");
		
		FileInputStream inPut = new FileInputStream(target);
		FileOutputStream outPut = new FileOutputStream(copy);
		while(true) {
			int a = inPut.read();
			if(a == -1) break;
			outPut.write(a);
		}
		inPut.close();
		outPut.close();
		
	}
}
