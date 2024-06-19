package api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test04로또번호출력프로그램 {
	public static void main(String[] args) throws IOException {
		
		File lotto = new File("sample", "lotto.txt");
		FileInputStream stream = new FileInputStream(lotto);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream combine = new DataInputStream(buffer);
		
		int a = combine.readInt(); 
		int b = combine.readInt(); 
		int c = combine.readInt(); 
		int d = combine.readInt(); 
		int e = combine.readInt();
		int f = combine.readInt();
		
		combine.close();
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = "+ f);
		
	}
}
