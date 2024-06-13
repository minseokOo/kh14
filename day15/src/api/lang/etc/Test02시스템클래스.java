package api.lang.etc;

public class Test02시스템클래스 {
	public static void main(String[] args) {
		//System 클래스
		// - 이 프로그램을 감싸고 있는 외부 시스템에 접근할 수 있는 클래스
		// - 외부 시스템은 운영체제(OS, Operating System)을 말함
		
		System.err.println("에러메세지");
		System.out.println("일반메세지");
		long time = System.currentTimeMillis(); //현재시각 
		System.out.println(time);
		
		long time2 = System.nanoTime();//현재시각 (기준없음)
		System.out.println(time2);
		
		//System.out.println(System.getProperties());
		
		String osName = System.getProperty("os.name");
		System.out.println("운영체제명 : " + osName);
		
		String javaVersion = System.getProperty("java.version");
		System.out.println("자바 버전 : " + javaVersion);
		
		String country = System.getProperty("user.country");
		System.out.println("국가 : " + country);
		
		String language = System.getProperty("user.language");
		System.out.println("언어 : " + language);
		
		String home = System.getProperty("user.home");
		System.out.println("사용자 폴더 : " + home);
		
		String dir = System.getProperty("user.dir");
		System.out.println("실행 위치 : " + dir);
		 
		//프로그램 종료
		// - 종료 시 정수로 상태를 알려준다
		// - 0은 정상종료이고, 나머지는 비정상종료로 간주
		System.exit(0);
		System.out.println("이 메세지는 안보여요");
		
	}
}
