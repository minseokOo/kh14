package api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01멀티바이트출력 {
	public static void main(String[] args) throws IOException {
		// 준비물
		// 1. 제어용 파일 객체
		// 2. 출력용 통로 객체
		// 3. 임시 저장용 버퍼 객체 (보조 스트림)
		// 4. 분해용 객체 (보조 스트림)
		
		File target = new File("sample", "multi.txt");
		FileOutputStream stream = new FileOutputStream(target);// 2
		BufferedOutputStream buffer = new BufferedOutputStream(stream);// 3
//		BufferedOutputStream buffer = new BufferedOutputStream(stream, 10);// 3
		DataOutputStream mixer = new DataOutputStream(buffer); // 4
		
		//[프로그램] -> [mixer] -> [buffer] -> [stream] -> [target] -> [실제파일]
		
		//보내고 싶은 데이터에 맞게 출력명령을 호출
		mixer.writeInt(100);//100 을 int에 맞게 출력 (4조각)
		mixer.writeLong(100); // 100을 long에 맞게 출력 (8조각)
		mixer.writeChar(100); // 100을 char에 맞게 출력 (2조각)
		mixer.writeFloat(100); // 100을 float에 맞게 출력 (4조각)
		mixer.writeDouble(100); // 100을 double에 맞게 출력 (8조각)
		
		//버퍼에 남은 내용을 모두 전송시켜야 한다
		mixer.flush(); //전송
		mixer.close(); //전송 + 닫기
		
	}
}
