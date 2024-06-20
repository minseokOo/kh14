package api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03나라이름대기2 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//파일이 있다면...
		//저장소를 생성해야합니까? 몰라요
		//파일에 저장소가 있을 수도 있어요

		//객체 입력
		File target = new File("files", "memory.kh");
		Set<String> memory;
		if(target.isFile()) {//파일이 존재하면 파일에 들어있는 저장소를 추출
			FileInputStream stream = new FileInputStream(target);
			BufferedInputStream buffer = new BufferedInputStream(stream);
			ObjectInputStream combine = new ObjectInputStream(buffer);
			memory = (Set<String>) combine.readObject();
			combine.close();
		}
		else {//파일이 존재하지 않으면 신규 생성
			memory = new HashSet<>();
		}

		//사용자 입력
		Scanner sc = new Scanner(System.in);

		System.out.print("나라 입력 : ");
		String name = sc.nextLine();

		if(memory.contains(name)) {
			System.out.println("["+name+"] 이미 입력한 국가입니다");
		}
		else {
			memory.add(name);
			System.out.println("["+name+"] 등록되었습니다");
		}

		sc.close();

		//저장소를 파일로 객체 출력
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream mixer = new ObjectOutputStream(buffer);

		mixer.writeObject(memory);

		mixer.close();

	}
}

