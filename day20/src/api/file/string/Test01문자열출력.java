package api.file.string;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test01문자열출력 {
	public static void main(String[] args) throws IOException {
		//문자열은 바이트로 변환이 가능하다
		
		//String str = "Hello Java!";
		String str = "안녕 자바!";
		
		byte[] by1 = str.getBytes();
		byte[] by2 = str.getBytes("MS949");
		byte[] by3 = str.getBytes("UTF-8");
		
//		System.out.println(Arrays.toString(by1));
//		System.out.println(Arrays.toString(by2));
//		System.out.println(Arrays.toString(by3));
		
		//by1을 싱글바이트 형식으로 파일에 저장
		File target = new File("files", "string.kh");
		FileOutputStream stream = new FileOutputStream(target);
		
		stream.write(by1);
		
		stream.close();
		
	}
}
