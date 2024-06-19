package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02싱글바이트입력 {
	public static void main(String[] args) throws IOException {
		// sample/single.txt 를 읽는 예제

		// 싱글바이트 입력
		// 준비물 :
		// (1) 파일 제어를 위한 객체
		File target = new File("./sample", "single.txt");
		// (2) 입력을 위한 통로 객체
		FileInputStream stream = new FileInputStream(target);

		// 싱글바이트 입력 시 읽을 값이 없으면 -1을 반환
		// 즉, -1이 나오면 입력이 끝났다는 의미
		//EOF(End Of File)가 -1이라고 표현
		while (true) {
			int a = stream.read();
			if(a == -1) break;
			System.out.println(a);
			
		}
	}
}
