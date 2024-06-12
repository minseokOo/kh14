package api.lang.string;

public class Test06문자열편집 {
	public static void main(String[] args) {
		//문자열은 "불변(immutable)"입니다.
		// - 크기, 형태 등 자유도가 높기 때문에 성능을 위해 불변 처리를 했음
		// - 문자열 편집 명령은 원본을 바꾸는 것이 아니라 신규 문자열을 생성
		
		String word = "Hello Java!";
		
		String upper = word.toUpperCase();
		System.out.println("word = " + word);
		System.out.println("upper = " + upper);
		System.out.println("lower = " + word.toLowerCase());
		
		System.out.println("자르기 = " + word.substring(0,4));
		System.out.println("자르기 = " + word.substring(6));
		
		//불필요한 여백제거
		// - 공백이 아닌 첫 글자 이전과 마지막 글자 이후를 제거
		// - 아스키코드 공백만 처리하는 명령 - trim()
		// - 유니코드 공백까지 처리하는 명령 - strip()
		String url1 = "            www.naver.com            ";
		String url2 = "　　　　www.google.com　　　　";
		System.out.println(url1.trim());
		System.out.println(url1.strip());
		System.out.println(url2.trim());
		System.out.println(url2.strip());
		
		//문자열 치환
		String text = "나는 자바가 싫어요";
		System.out.println(text.replace("자바", "피자"));
		System.out.println(text.replace("싫어", "좋아"));
		System.out.println(text.replace("자바", "피자").replace("싫어", "좋아"));
		
		
	}
}
