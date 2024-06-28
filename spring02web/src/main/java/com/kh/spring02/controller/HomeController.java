package com.kh.spring02.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //사용자가 접속할 수 있는 도구(요청 처리 도구)
public class HomeController {

	@RequestMapping("/home") //접속 가능한 주소를 생성하는 도구
	public String home() {
		return "Welcome Spring Boot!"; 
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Hola!";
	}

	@RequestMapping("/dice")
	public String dice() {
		Random r = new Random();
		int number = r.nextInt(6)+1;
		return "주사위 : "+number;
	}
	
	@RequestMapping("/lotto")
	public String lotto() {
		Random r = new Random();
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <6; i++) {
			int number = r.nextInt(45)+1;
			if(!numbers.contains(number)) {
			numbers.add(number);
			}
			else {
				i--;
			}
		}
		return "로또 번호 : " + numbers;
	}
	
	// (Q) 사용자가 전달하는 데이터를 어떤 식으로 받을 것인가?
	// - Scanner 를 어떻게 대체할 것 인가?
	// - 주소에서 '?' 뒤에 작성되는 값들을 파라미터(Parameter)라 부름
	// - '?' 는 주소와 파라미터를 구분하는 기호, '&'은 파라미터와 파라미터를 구분하는 기호
	// - 지금 보고 싶은건 컨트롤러에서 파라미터를 어떻게 받는지에 대한 것
	
	@RequestMapping("/plus")
	public String plus(
			@RequestParam int a, @RequestParam int b) {
		int c = a + b;
		return "덧셈 결과 : " + c;
	}
	
	// (Q) 주소 : /average
	// 국어(korean), 영어(english), 수학(math) 점수를 전달받아 평균 출력
	@RequestMapping("/average")
	public String average(
			@RequestParam int korean, 
			@RequestParam int english, 
			@RequestParam int math) {
		float average = ((float)korean + english + math)/3;
		return "평균 점수 : " + average + "점";
	}
	
	
	// (Q) 주소 : /subway
	// 사용자의 나이(age)를 전달받아 예상 지하철 요금 출력
	//(+추가) 나이가 전달되지 않는다면 성인 요금을 출력
	@RequestMapping("/subway")
	//public String subway(@RequestParam  int age) {
	public String subway(
			@RequestParam(required = false, defaultValue = "999")  int age) {	
		int price;
		String a;
		if(age<8 || age >64) {
			price = 0;
			a = "미취학 아동 또는 노인";
		}
		else if (age > 20) {
			price = 1300;
			a= "성인";
		}
		else if (age >13) {
			price = 1000;
			a="학생";
		}
//		else if (age == 999) {
//			re
//			System.out.println("미취학 아동 또는 노인 요금 : 0원");
//			System.out.println("성인 요금 : 1300원");
//			System.out.println("학생 요금 : 1000원");
//			System.out.println("어린이 요금 : 700원");
//		}
		
		else {
			price = 700;
			a="어린이";
		}
		return a + " 지하철 요금 : " + price + "원";
	}
	
	// (Q) 보여줄 내용이 많으면?
	// (ex) /repeat 라는 Hello Spring 10번 출력
	@RequestMapping("/repeat")
	public String repeat(@RequestParam(required = false, defaultValue = "1") int count) {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i < count; i++) {
		buffer.append("Hello Spring <br>");
		}
		return buffer.toString();
	}
}
