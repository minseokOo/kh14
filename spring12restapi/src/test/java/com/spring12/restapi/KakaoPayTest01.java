package com.spring12.restapi;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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
public class KakaoPayTest01 {
	@Test
	public void test() throws URISyntaxException {
		//카카오페이의 단건 결제 준비
		//- 우리 서버에서 카카오페이 서버로 메세지를 보내야 한다
		//- RestTemplate 이용하는 방법과 WebClient를 이용하는 방법이 존재
		
		//1. 도구 생성(RestTemplate)
		RestTemplate template = new RestTemplate();
		
		//2. 주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");//유효하지 않은 주소면 오류가 발생
		
		//3. 헤더 생성
		HttpHeaders headers = new HttpHeaders();
		//headers.add("key", "value");
		headers.add("Authorization", "SECRET_KEY DEV484590624F56F787ACBE159D8000B519E039A");
		headers.add("Content-Type", "application/json");
		
		//4. 바디 생성
		Map<String, String> body = new HashMap<>();
		//body.put("key", "value");
		body.put("cid", "TC0ONETIME");
		body.put("partner_order_id", UUID.randomUUID().toString());
		body.put("partner_user_id", UUID.randomUUID().toString());
		body.put("item_name", "에러해결권");
		body.put("quantity", "1");
		body.put("total_amount", "99000");
		body.put("tax_free_amount", "0");
		body.put("approval_url", "http://localhost:8080/success");
		body.put("cancel_url", "http://localhost:8080/cancel");
		body.put("fail_url", "http://localhost:8080/fail");
		
		//5. 통신 요청 정보 객체 생성(3 + 4)
		HttpEntity entity = new HttpEntity(body, headers);
		
		//6. 전송 후 응답받기(2 + 5)
		Map response = template.postForObject(uri, entity, Map.class);
		log.info("response = {}", response);
		
		//다음 테스트(승인)에 필요한 정보를 출력
		//- tid, partner_order_id, partner_user_id
		log.info("tid = {}", response.get("tid"));
		log.info("partner_order_id = {}", body.get("partner_order_id"));
		log.info("partner_user_id = {}", body.get("partner_user_id"));
	}
	
}
