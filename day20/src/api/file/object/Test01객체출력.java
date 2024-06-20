package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01객체출력 {
	public static void main(String[] args) throws IOException {
		
		//디렉터리 생성
		File dir = new File("./files");
		dir.mkdirs();

		//준비물
		//(1) 제어용 파일 객체
		//(2) 출력용 통로 객체
		//(3) 임시 저장용 통로 객체 (보조 스트림)
		//(4) 직렬화 및 분해 객체 (보조 스트림)
		File target = new File(dir, "object.txt");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream mixer = new ObjectOutputStream(buffer);
		
		//mixer에 객체를 전달
		Date d = new Date();
		mixer.writeObject(d);
		
		//정리
		mixer.close();
		
		
	}
}
