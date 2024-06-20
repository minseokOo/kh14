package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test03나라이름대기 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		File dir = new File("./country");
		dir.mkdirs();
		
		System.out.print("나라 이름 입력 : ");
		String input = sc.next();
		File target = new File(dir, input);
		
		if(!target.exists()){
		System.out.println("[" + input + "]이 등록되었습니다." );
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream mixer = new ObjectOutputStream(buffer);
		}
		else {
		System.out.println("[" + input + "]은 이미 등록된 나라입니다.");
		}
		
	}
}
