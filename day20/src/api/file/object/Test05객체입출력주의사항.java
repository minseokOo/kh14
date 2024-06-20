package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Test05객체입출력주의사항 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//객체 입출력 시 주의 사항은 없을까?
		
		File target = new File("files", "object2.kh");
		ObjectOutputStream mixer = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(target)));
		
//		Scanner sc = new Scanner(System.in);
//		mixer.writeObject(sc);
		
		Random r = new Random();
		mixer.writeObject(r);
		
		mixer.close();
				
		
	}
}
