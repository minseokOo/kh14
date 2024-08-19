package com.kh.spring06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //스케쥴링 서비스 활성화 설정
@SpringBootApplication
public class Spring06integratedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring06integratedApplication.class, args);
	}

}
