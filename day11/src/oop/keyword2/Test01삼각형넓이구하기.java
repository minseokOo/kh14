package oop.keyword2;

public class Test01삼각형넓이구하기 {
	public static void main(String[] args) {

		// (Q) 밑변 5, 높이 7인 삼각형의 넓이를 구하시오.

		Calculator c = new Calculator(5, 7);

		System.out.println(c.getArea());
	}
}