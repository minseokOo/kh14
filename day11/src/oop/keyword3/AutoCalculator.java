package oop.keyword3;

import java.util.Random;

public class AutoCalculator {

	
	public static int multiple(int a, int b) {
		return a * b;
	}
	public static double multiple(double a, double b) {
		return a * b;
	}
	public static int square(int a) {
		return a*a;
	}
	public static float circle(int a) {
		return square(a) * 3.14f;
	}
	public static int random(int a, int b) {
		Random r = new Random();
		return r.nextInt(b-a+1)+a;
	}
	public static int lotto() {
		Random r = new Random();
		return r.nextInt(45) + 1;
	}
}
