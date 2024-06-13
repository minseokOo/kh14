package api.lang.etc;

import java.io.IOException;

public class Test03런타임클래스 {
	public static void main(String[] args) throws IOException {
		//Runtime 클래스
		// - 직접 객체 생성은 불가능하지만 생성된 객체를 이용할 수는 있다
		// - 생성 메소드를 찾아야 한다 (반환형이 Runtime 이다)
		
		Runtime rt = Runtime.getRuntime(); //간접 생성(생성 의뢰)
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().startsWith("window")) {
		rt.exec("notepad"); //Window 가 아니면 안된다는 경고
		rt.exec("calc");
		rt.exec("mspaint");
		}
	}
}
