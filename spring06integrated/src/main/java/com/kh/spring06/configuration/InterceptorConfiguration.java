package com.kh.spring06.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 커스텀 설정 파일
 
 @Configuration으로 등록 후 필요하다면 상속을 받아서 자격을 획득해야함
 */

import com.kh.spring06.interceptor.TestInterceptor;
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//목표 : 모든 페이지가 실행되기 전에 testInterceptor가 간섭하게 하고 싶다.
		registry.addInterceptor(testInterceptor)
						.addPathPatterns("/poketmon/**");
		
		
	}
	
}
