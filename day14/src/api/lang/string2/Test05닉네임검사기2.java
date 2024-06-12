package api.lang.string2;

import java.util.Scanner;

public class Test05닉네임검사기2 {
public static void main(String[] args) {
	//부정 탐색 (negative lookahead)
	// - 특정 패턴을 배제하는 조건식
	// - (?!글자) 형태로 작성하며 검사식과 별개로 작성
	// - (.*?) 표현을 통해 "통과"의 의미를 표현 할 수 있음
	
//	긍정 탐색(positive lookahead)
//	- 특정 패턴을 강제하는 조건식
//	- (?=글자) 형태로 작성
	Scanner sc = new Scanner(System.in);
	System.out.print("사용 할 닉네임을 입력하세요 : ");
	String name = sc.next();
	String regexName = "^([가-힣]|[0-9]){1,10}$";
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