package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class Test02객체입력 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//준비물
		//(1) 제어용 파일 객체
		//(2) 입력용 통로 객체
		//(3) 임시 저장용 통로 객체(보조 스트림)
		//(4) 역직렬화 및 조립 객체(보조 스트림)
		
		File target = new File("./files", "object.txt");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream combine = new ObjectInputStream(buffer);
		
		// [프로그램] <- [combine] <- [buffer] <- [stream] <- [target] <- [실제파일]
		
		Date obj = (Date) combine.readObject(); //down-casting
		
		combine.close();
		
		System.out.println(obj);
		
	}
}
