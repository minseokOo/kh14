package com.kh.spring06.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.spring06.error.TargetNotFoundException;

@ControllerAdvice(annotations = {Controller.class})
public class ExceptonAdvice {
	//예외 처리기
	@ExceptionHandler(TargetNotFoundException.class)
	public String notFound() {
		return "/WEB-INF/views/error/notFound.jsp";
	}
}
