package com.spring12.mybatis.advice;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

//@RestControllerAdvice(basePackages = {"com.spring12.mybatis.restcontroller"})
//@ControllerAdvice(annotations =  {Controller.class})
public class EmptyStringAdvice {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
