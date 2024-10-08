package com.spring12.restapi;

import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.restapi.service.KakaoPayService;
import com.spring12.restapi.vo.pay.KakaoPayReadyRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest03 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		// 준비 - kakaoPayReadyRequestVO
		KakaoPayReadyRequestVO request = new KakaoPayReadyRequestVO();
		request.setPartnerOrderId(UUID.randomUUID().toString());
		request.setPartnerUserId("testuser1");
		request.setItemName("테스트");
		request.setTotalAmount(99000);
		
		//처리
		KakaoPayReadyResponseVO response = kakaoPayService.ready(request);
		
		//출력
		log.info("tid = {}", response.getTid());
		log.info("url = {}", response.getNextRedirectPcUrl());
		log.info("partner_order_id = {}", request.getPartnerOrderId());
		log.info("partner_user_id = {}", request.getPartnerUserId());
		
		
	}
}
