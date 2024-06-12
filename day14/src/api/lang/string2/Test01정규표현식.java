package api.lang.string2;

public class Test01정규표현식 {
	public static void main(String[] args) {
		//(Q) 사용자가 입력한 글자가 올바른 휴대전화번호인지 검사하세요.
		
		String input = "010-3456-7890";
		
		String regex = "^010-[123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
		String regex2 = "^010-[1-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
		String regex3 = "^010-[1-9][0-9]{3}-[0-9]{4}$";
		System.out.println(input.matches(regex));
		System.out.println(input.matches(regex2));
		System.out.println(input.matches(regex3));
		
	}
}
