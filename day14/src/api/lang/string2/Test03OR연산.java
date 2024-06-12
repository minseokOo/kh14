package api.lang.string2;

public class Test03OR연산 {
	public static void main(String[] args) {
		//OR연산 - 두 단어중 하나가 나오면 통과
		
		String input1 = "hi";
		String regex1 = "^(hi|hello)$";
		System.out.println(input1.matches(regex1));
		
		// 정규 표현식으로 구현하기 어려운 것(범위표현)
		// (ex) IP 주소 검사
		// - aaa.bbb.ccc.ddd 형태이며 a, b, c, d 에는 0부터 255까지 작성 가능
		
		String ip = "256.168.30.59";
		String ipRegex = "^([0-9]|[1-9][0-9]|(1[0-9]{2}|2([1-4][0-9]|5[0-5])))\\.([0-9]|[1-9][0-9]|(1[0-9]{2}|2([1-4][0-9]|5[0-5])))\\.([0-9]|[1-9][0-9]|(1[0-9]{2}|2([1-4][0-9]|5[0-5])))\\.([0-9]|[1-9][0-9]|(1[0-9]{2}|2([1-4][0-9]|5[0-5])))$";
		System.out.println(ip.matches(ipRegex));
		
	}
}
