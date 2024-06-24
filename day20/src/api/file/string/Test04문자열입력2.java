package api.file.string;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test04문자열입력2 {
	public static void main(String[] args) throws IOException {

		File target = new File("files", "string2.kh");
		Scanner sc = new Scanner(target);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println("line = " + line);
		}

		sc.close();
	}
}
