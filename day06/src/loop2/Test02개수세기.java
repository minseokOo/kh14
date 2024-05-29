package loop2;

public class Test02개수세기 {

	public static void main(String[] args) {

		int count3 = 0;
		int count5 = 0;
		int count7 = 0;
		for(int i = 1; i <= 1000000; i++) {
			if(i % 3 == 0) {
				count3++;
			}
			if(i % 5 == 0) {
				count5++;
			}
			if(i % 7 == 0) {
				count7++;
			}
		}
		System.out.println("3의 배수의 개수는 " + count3 + "개");
		System.out.println("5의 배수의 개수는 " + count5 + "개");
		System.out.println("7의 배수의 개수는 " + count7 + "개");
	}

}
