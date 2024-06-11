package api.lang.string;

public class Test04문자열검사 {
	public static void main(String[] args) {
		
		String url = "https://www.naver.com/";
		
		//이 주소는 보안이 강화된 주소인가요?
		//= url에 있는 문자열이 https로 시작하나요?
		System.out.println(url.startsWith("https"));
		
		//이 주소는 .com으로 끝나나요?
		System.out.println(url.endsWith(".com"));
		
		//이 주소에 naver가 들어있어요?
		System.out.println(url.contains("naver")); //있는지 없는지 찾을때 사용
		System.out.println(url.indexOf("naver")); //왼쪽부터 위치를 찾음(없을시 음수가 나옴)
		System.out.println(url.lastIndexOf("naver")); //오른쪽부터 위치를 찾음
		System.out.println(url.matches("(.*?)naver(.*?)"));//패턴으로 비교하는 명령
		
		//글자수
		// - url 은 몇 글자인가요?
		System.out.println(url.length());
		// - url 은 허용 가능한 범위의 글자수인가요?
		System.out.println(url.length() <= 2083);
		
		//특정 위치의 글자만 추출
		System.out.println(url.charAt(12));
		System.out.println(url.substring(12, 17));
		
	}
}
