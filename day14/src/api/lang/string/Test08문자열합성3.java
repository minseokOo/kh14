package api.lang.string;

public class Test08문자열합성3 {
	public static void main(String[] args) {
		
		//StringBuffer, StringBulider를 이용하면 문자열 합성을 빠르게 할 수 있다.
		
		StringBuilder buffer = new StringBuilder();
		
		long begin = System.currentTimeMillis(); //기준시 1970-01-01
		for(int i=0; i < 100; i++) {
			buffer.append("*");
		}
		String star = buffer.toString();
		long end = System.currentTimeMillis();
		
		long time = end - begin;
		System.out.println("소요시간 = " + time + "밀리초");
		
		//System.out.println("star = " + star);
		
	}
}
