package api.file.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04싱글바이트대용량출력 {
	public static void main(String[] args) throws IOException {
		
		// 준비물
		// (1) 제어용 파일 객체
		// (2) 출력용 통로 객체
		
		File target = new File("sample", "single2.txt");
		FileOutputStream stream = new FileOutputStream(target); //2
		
		byte[] data = new byte[] {104, 101, 108, 108, 111};
		stream.write(data);//data 배열에 있는 모든 값을 한 번에 보내세요
		stream.write(data);
		stream.write(data);
		stream.write(data);
		stream.write(data);
		stream.write(data, 1, 3);//data 배열의 값을 1번부터 3개 보내세요
		stream.write(data, 0, 4);
		
		stream.close();
	}
}
