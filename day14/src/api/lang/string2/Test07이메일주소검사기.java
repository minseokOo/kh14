package api.lang.string2;

public class Test07이메일주소검사기 {
	public static void main(String[] args) {
		
		String email = "khacademy@naver.com";
		int at = email.indexOf("@");
		int dot = email.indexOf(".");
		String local = email.substring(0, at);
		
		System.out.println(at);
		System.out.println(dot);
		System.out.println(local);
	}
}
