package api.file.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01싱글바이트출력 {
	public static void main(String[] args) throws IOException {
		
		// 싱글 바이트 출력
		// 준비물 : (1) 파일 제어를 위한 객체, (2) 파일 출력용 통로
		File dir = new File("./sample");
		dir.mkdirs();
		
		File target = new File("sample", "single.txt");
		
		FileOutputStream stream = new FileOutputStream(target); //(2)
		//[프로그램] -> [통로] -> [target] -> [실제파일]
		//					[stream]

		//stream 에 데이터를 출력(쓰기)
		stream.write('A');// A를 내보내세요!
		stream.write(66); // 아스키 코드 66번을 내보내세요!
		stream.write(32); // 아스키 코드 32번을 내보내세요!
		stream.write(104);
		stream.write(101);
		stream.write(108);
		stream.write(108);
		stream.write(111);
		stream.write('\n'); //enter
		stream.write('0');
		
		//다 사용한 통로는 메모리 관리를 위해 정리
		stream.close();
	}
}
