package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사하기2 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("D:\\설치 프로그램", "amazon-corretto-17.0.11.9.1-windows-x64.msi");
		File copy = new File ("D:\\test", "amazon-corretto-17.0.11.9.1-windows-x64.msi");
		
		FileInputStream inPut = new FileInputStream(target);
		FileOutputStream outPut = new FileOutputStream(copy);
		while(true) {
			int a = inPut.read();
			System.out.println(a);
			if(a == -1) break;
			outPut.write(a);
		}
		inPut.close();
		outPut.close();
		
	}
}
