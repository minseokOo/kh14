package com.spring12.restapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest02 {
	
	@Test
	public void test() throws URISyntaxException {
		//카카오페이 결제 승인 
		// - 결제 준비 이후 벌어지는 과정
		
		//1. 도구 생성(RestTemplate)
				RestTemplate template = new RestTemplate();
				
				//2. 주소 생성
				URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");//유효하지 않은 주소면 오류가 발생
				
				//3. 헤더 생성
				HttpHeaders headers = new HttpHeaders();
				//headers.add("key", "value");
				headers.add("Authorization", "SECRET_KEY DEV484590624F56F787ACBE159D8000B519E039A");
				headers.add("Content-Type", "application/json");
				
				//4. 바디 생성
				Map<String, String> body = new HashMap<>();
				//body.put("key", "value");
				body.put("cid", "TC0ONETIME");
//				body.put("partner_order_id", UUID.randomUUID().toString());
//				body.put("partner_user_id", UUID.randomUUID().toString());
//				body.put("tid", 거래번호);
//				body.put(null, null)
				body.put("partner_order_id", "68f798fe-4dfb-449f-8f1d-0a6257c18ad3");
				body.put("partner_user_id", "f82de355-75e8-4f61-8387-d3c8e5948c90");
				body.put("tid", "T7048f5a7f575eb07d55");
				
				//5. 통신 요청 정보 객체 생성(3 + 4)
				HttpEntity entity = new HttpEntity(body, headers);
				
				//6. 전송 후 응답받기(2 + 5)
				Map response = template.postForObject(uri, entity, Map.class);
				log.info("response = {}", response);
			}
			
		}