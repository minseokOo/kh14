package api.lang.string;

public class Test08문자열합성 {
	public static void main(String[] args) {
		
		//문자열은 "불변(immutable)"이다.
		//합성에 문제가 있다.
		
		String star = "";
		
		long begin = System.currentTimeMillis(); //기준시 1970-01-01
		for(int i=0; i < 10; i++) {
			star += "*";
		}
		long end = System.currentTimeMillis();
		
		long time = end - begin;
		System.out.println("소요시간 = " + time + "밀리초");
		
		System.out.println("star = " + star);
		
	}
}
