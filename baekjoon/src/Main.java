import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		sc.close();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(A);
		numbers.add(B);
		numbers.add(C);
		
		Collections.sort(numbers);
		System.out.println(numbers.get(1));
		
		
		
	}
}
