import java.util.Scanner;

public class Main {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			String input = sc.nextLine();
			sc.close();
			
			String regex = "^[가-힣0-9ㄱ-ㅎㅏ-ㅣ]{1,10}$";
			
			System.out.println(input.matches(regex));
		
	}
}
