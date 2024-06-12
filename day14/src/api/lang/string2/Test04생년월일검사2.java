package api.lang.string2;


public class Test04생년월일검사2 {
	public static void main(String[] args) {
	
		//윤년은 정규 표현식만으로 어렵다(배수판정이 불가능)
		// - 프로그래밍 코드로 윤년을 계산 시켜야한다.
		String birthday = "1997-08-25";
		String regexBirthday = "^(19[0-9]{2}|(20([01][0-9]))|2[0-3])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
		
		System.out.println(birthday.matches(regexBirthday));
		

		
}
}
