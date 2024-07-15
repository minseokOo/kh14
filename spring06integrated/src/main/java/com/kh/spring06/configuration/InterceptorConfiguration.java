package com.kh.spring06.configuration;

import java.rmi.registry.Registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 커스텀 설정 파일
 
 @Configuration으로 등록 후 필요하다면 상속을 받아서 자격을 획득해야함
 */

import com.kh.spring06.interceptor.AdminInterceptor;
import com.kh.spring06.interceptor.MemberInterceptor;
import com.kh.spring06.interceptor.TestInterceptor;
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//목표 : 모든 페이지가 실행되기 전에 testInterceptor가 간섭하게 하고 싶다.
		registry.addInterceptor(testInterceptor)
						.addPathPatterns("/poketmon/**");
		
		//회원 검사 인터셉터 등록
		// - 와일드카드 (*)는 어떤 글자가 와도 관계 없는 자리라는 뜻
		// - 와일드카드가 한개면 현재 엔드포인트에서 글자만 무관이라는 뜻
		// - 와일드카드가 두개면 하위 엔드포인트를 모두 포함 한다는 뜻
		registry.addInterceptor(memberInterceptor)
						.addPathPatterns(
						"/emp/**", //모든 사원 페이지
						"/book/**", //모든 도서페이지
						"/member/**", //모든 회원페이지
						"/board/write"//게시글 작성페이지
								)
						.excludePathPatterns(
								"/member/join*", //가입페이지
//								"/member/joinFinish", //가입 완료 페이지
								"/member/login", //로그인 페이지
								"/member/goodbye", //탈퇴완료 페이지
								"/member/block"
								);
		//관리자 검사 인터셉터 설정
		registry.addInterceptor(adminInterceptor).addPathPatterns(
				 "/admin/**" //모든 관리자 페이지
				)
		.excludePathPatterns(
				"/member/join*", //가입페이지
//				"/member/joinFinish", //가입 완료 페이지
				"/member/login", //로그인 페이지
				"/member/goodbye" //탈퇴완료 페이지
				);
	}
	
	
	
}
