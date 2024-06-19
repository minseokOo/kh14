package api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02멀티바이트입력 {
	public static void main(String[] args) throws IOException {
		// 준비물
		// 1. 제어용 파일 객체
		// 2. 출력용 통로 객체
		// 3. 임시 저장용 버퍼 객체 (보조 스트림)
		// 4. 조립용 객체 (보조 스트림)
		
		File target = new File("sample", "multi.txt");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream combine = new DataInputStream(buffer);
		
		//[프로그램] <- [combine] <- [buffer] <- [stream] <- [target] <- [실제파일]
		
		//combine에 읽고 싶은 종류별 명령을 사용하여 입력
		//(주의) 반드시 출력한 순서대로 입력을 해야 합니다.
		
		int a = combine.readInt(); // 4조각을 모아서 int로 주세요
		long b = combine.readLong(); //8조각을 모아서 long로 주세요
		char c = combine.readChar(); //2조각을 모아서 char로 만들어 주세요
		float d = combine.readFloat(); //4조각을 모아서 float로 만들어 주세요
		double e = combine.readDouble(); // 8조각을 모아서 double로 만들어주세요
		
		combine.close();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
	}
}
