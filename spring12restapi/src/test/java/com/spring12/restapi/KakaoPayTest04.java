package com.spring12.restapi;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring12.restapi.service.KakaoPayService;
import com.spring12.restapi.vo.pay.KakaoPayApproveRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayApproveResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest04 {

	@Autowired
	private KakaoPayService kakaoPayService;
	@Test
	public KakaoPayApproveResponseVO test() throws URISyntaxException {
		//준비
		KakaoPayApproveRequestVO request = new KakaoPayApproveRequestVO();
		request.setPartnerOrderId("4e60b36e-984d-49c7-83d4-03976e3c802b");
		request.setPartnerUserId("testuser1");
		request.setTid("T704b6dd0580639354c8");
		request.setPgToken("1fec4cc9a4ef4dfc6422");
		
		//처리
		KakaoPayApproveResponseVO response = kakaoPayService.approve(request);
		return response;
	}
}
