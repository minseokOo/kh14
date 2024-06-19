package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Test06파일복사하기2 {
	public static void main(String[] args) throws IOException {

		File input = new File("sample", "single.txt");
		File output = new File("sample", "copy.txt");

		byte[] data = new byte[5];
		long total = input.length();
		long copy = 0L;
		FileInputStream inputStream = new FileInputStream(input);
		FileOutputStream outputStream = new FileOutputStream(output);

		while (true) {
			int a = inputStream.read(data);
			if (a == -1) 
				break;
				outputStream.write(data, 0, a);
				System.out.println("size = " + a + ", " + Arrays.toString(data));
				copy += a;
				float percent = copy * 100F/total;
				System.out.println(copy + " / " + total + "(" + percent + "%)");
		}
		inputStream.close();
		outputStream.close();
	}
}
