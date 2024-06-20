package api.file.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test02Writer사용 {
	public static void main(String[] args) throws IOException {
		//바이트 변환이나 임시 저장이 힘들어서 새로운 클래스 사용
		
		String str = "안녕 자바!";
		
		File target = new File("files", "string2.kh");
//		FileOutputStream stream = new FileOutputStream(target);
		FileWriter fw = new FileWriter(target);
		
		fw.write(str);
		fw.write("\n");
		fw.write("반가워!");
		fw.write("\n");
		fw.write("뻥이야!");
		fw.close();
		
	}
}
