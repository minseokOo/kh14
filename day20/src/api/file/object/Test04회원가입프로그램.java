package api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test04회원가입프로그램 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File dir = new File("./member");
		dir.mkdirs();
		
		File target = new File("./member", "member.kh");
		
		Map<String, String>memory;
		if(target.isFile()) {
			FileInputStream stream = new FileInputStream(target);
			BufferedInputStream buffer = new BufferedInputStream(stream);
			ObjectInputStream combine = new ObjectInputStream(buffer);
			memory = (Map<String, String>) combine.readObject();
			combine.close();
		}
		else {
			memory = new HashMap<String, String>();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		String regex = "^[a-z][A-Za-z0-9_-]{4,19}$";
		String regexPassword = "^([A-Z]|[a-z]|[0-9]|([!-\\\\]|[:-@]|[\\[-`]|[{-~])){8,16}$";
		System.out.print("비밀번호 입력 : ");
		String password = sc.next();
		
		if(memory.containsKey(id)) {
			System.out.println("이미 사용중인 아이디 입니다.");
		}
		if (!id.matches(regex)|| !password.matches(regexPassword)) {
			System.out.println("아이디 또는 비밀번호를 확인해 주세요.");
		}
		else {
			System.out.println("사용 가능한 아이디 입니다.");
			memory.put(id, password);

			sc.close();
			
			FileOutputStream stream = new FileOutputStream(target);
			BufferedOutputStream buffer = new BufferedOutputStream(stream);
			ObjectOutputStream mixer = new ObjectOutputStream(buffer);
			
			mixer.writeObject(memory);
			
			mixer.close();
		}
		
		
	}
}
