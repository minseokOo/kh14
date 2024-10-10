package com.spring12.restapi.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring12.restapi.configuration.KakaoPayProperties;
import com.spring12.restapi.vo.pay.KakaoPayApproveRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayApproveResponseVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyResponseVO;

@Service
public class KakaoPayService {

	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	@Autowired
	private RestTemplate template;
	@Autowired
	private HttpHeaders headers;
	
	//결제 준비(ready)
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO request) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", request.getPartnerOrderId());
		body.put("partner_user_id", request.getPartnerUserId());
		body.put("item_name", request.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(request.getTotalAmount()));
		body.put("tax_free_amount", "0");
		body.put("approval_url", request.getApprovalUrl() + "/" + request.getPartnerOrderId());
		body.put("cancel_url", request.getCancelUrl());
		body.put("fail_url", request.getFailUrl());
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		KakaoPayReadyResponseVO response = 
				template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
		
	}
	
	// 결제 승인(approve)
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO request) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", request.getPartnerOrderId());
		body.put("partner_user_id", request.getPartnerUserId());
		body.put("tid", request.getTid());
		body.put("pg_token", request.getPgToken());
HttpEntity entity = new HttpEntity(body, headers);
		
		KakaoPayApproveResponseVO response = template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		return response;
	}
	
}
