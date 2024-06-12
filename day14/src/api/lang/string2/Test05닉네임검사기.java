package api.lang.string2;

import java.util.Scanner;

public class Test05닉네임검사기 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("사용 할 닉네임을 입력하세요 : ");
	String name = sc.next();
	String regexName = "^(?!(.*?)운영[진자])[가-힣0-9]{1,10}$";
	if(name.contains("운영자")||name.contains("운영진")) {
		System.out.println("운영자 관련 닉네임은 사용 할 수 없습니다.");
	}
	else if (name.matches(regexName)){
	System.out.println("사용 할 수 있는 닉네임 입니다.");
	}
	else {
		System.out.println("닉네임은 한글과 숫자 10글자 이내로 작성하세요.");
	}
}
}