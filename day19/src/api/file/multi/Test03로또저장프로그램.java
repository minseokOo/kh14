package api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03로또저장프로그램 {

	public static void main(String[] args) throws IOException {

		Random r = new Random();
		List<Integer> a = new ArrayList<>(6);

		File lotto = new File("sample", "lotto.txt");
		FileOutputStream stream = new FileOutputStream(lotto);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream mixer = new DataOutputStream(buffer);
		
		
		for (int i = 0; i < 6; i++) {
			int number = r.nextInt(45) + 1;
			if (a.contains(number)) {
				i--;
			} else {
				a.add(number);
			}
		}
		Collections.sort(a);
		mixer.writeInt(a.get(0));
		mixer.writeInt(a.get(1));
		mixer.writeInt(a.get(2));
		mixer.writeInt(a.get(3));
		mixer.writeInt(a.get(4));
		mixer.writeInt(a.get(5));
		
		System.out.println(a);
		mixer.close();

	}
}
