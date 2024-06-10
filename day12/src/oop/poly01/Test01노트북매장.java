package oop.poly01;

import java.util.Scanner;

public class Test01노트북매장 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Laptop l1 = new Laptop(sc.next(), sc.next());
		
		l1.show();
	}
}
