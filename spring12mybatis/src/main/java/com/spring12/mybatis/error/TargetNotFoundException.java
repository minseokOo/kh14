package com.spring12.mybatis.error;


//내가 만든 예외 클래스
// - RuntimeException을 자바에서는 unchecked exception이라고 부른다
// - RuntimeException을 상속 받으면 별도의 예외 처리 절차를 작성하지 않아도 됨
// - 다 아는 사람들끼리 개발을 편하게 할 수 있다.

public class TargetNotFoundException extends RuntimeException{
	//기본 생성자
	public TargetNotFoundException() {}
	//예외 메세지를 전달 받는 생성자
	public TargetNotFoundException(String msg) {
		super(msg);
	}
}
