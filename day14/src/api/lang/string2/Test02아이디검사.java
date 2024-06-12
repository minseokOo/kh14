package api.lang.string2;

public class Test02아이디검사 {
	public static void main(String[] args) {
		
		String input = "a3415_-";
		
		String regex = "^[a-z][A-Za-z0-9_-]{4,19}$";
		
		System.out.println(input.matches(regex));
	}
}
