package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사하기3 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("sample", "single.txt");
		File copy = new File ("sample", "copy.txt");
		
		FileInputStream inPut = new FileInputStream(target);
		FileOutputStream outPut = new FileOutputStream(copy);

		long total = target.length();
		long copy2 = 0L;
		
		while(true) {
			int a = inPut.read();
			if(a == -1) break;
			outPut.write(a);
			copy2++;
			float percent = copy2 * 100f / total;
			System.out.println(copy2+"/"+total + "("+percent+"%)");
		}
		inPut.close();
		outPut.close();
		
	}
}
