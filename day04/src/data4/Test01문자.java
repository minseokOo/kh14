package data4;

public class Test01문자 {

	public static void main(String[] args) {

		//문자(char)
//		- 글자에 숫자를 붙여놓은 형태(글자로 써도 되고 숫자로 써도 됨)
//		- 글자로 쓸 때는 외따옴표에 한 글자만 넣을 수 있다.
//		- 기본적으로 MS949(CP949) 방식을 따른다.(윈도우)
//		- 2byte의 크기를 가짐
		
		char a = 'A';
		char b = 65;
		System.out.println(a);
		System.out.println(b);
		
		
		char c = '가'; //한글의 시작 글자
		System.out.println(c);
		System.out.println((int)c);
		
		char d = '힣'; //한글의 마지막 글자
		System.out.println(d);
		System.out.println((int)d);
		
		int ab = d - c;
		System.out.println(ab); //한글 개수
		
		
	}

}
