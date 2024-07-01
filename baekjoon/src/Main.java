import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int now = sc.nextInt();
		sc.close();
		
		int open = 1946;
		int var = now - open;
		
		System.out.println(var);
		
	}
}
