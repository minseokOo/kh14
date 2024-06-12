package api.lang.string2;

public class Test06비밀번호검사기 {
	public static void main(String[] args) {
		
		String password = "1Qw!";
		
		String regexPassword = "^([A-Z]|[a-z]|[0-9]|([!-\\\\]|[:-@]|[\\[-`]|[{-~])){8,16}$";
		String capital = "^[A-Z]$";
		String small = "^[a-z]$";
		String number = "^[0-9]$";
		String special = "^([!-\\\\]|[:-@]|[\\[-`]|[{-~])$";
		
		if(password.contains(capital)&&password.contains(small)
				&&password.contains(number)&&password.contains(special)) {
			System.out.println(password.matches(regexPassword));
		}
		else {
			System.out.println("8~16자의 영문 대/소문자, 숫자, 특수문자는 반드시 각각 1개이상 포함해주세요.");
		}
		
	}
}
