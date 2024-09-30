package com.spring12.mybatis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringdocConfiguration {

	//문서의 정보를 바꾸고 싶다면 OpenAPI라는 객체를 등록 할 수 있는 @Bean 생성 필요
	@Bean
	public OpenAPI apiInfo() {
//		//API 문서의 대표 정보 설정
//		Info info = new Info();
//		info.setVersion("v0.0.1");//버전
//		info.setTitle("내가 만든 REST API");//제목
//		info.setDescription("React에서 이용하기 위해 만든 백엔드 문서입니다.");
		
//		builder 패턴을 사용한 객체  생성
		Info info = new Info()
				.version("v0.0.1")
				.title("내가 만든 REST API")
				.description("React에서 이용하기 위해 만든 백엔드 문서입니다.");
		
//		OpenAPI api = new OpenAPI();
//		api.setInfo(info);
//		return api;
		
		return new OpenAPI().info(info);
	}
}