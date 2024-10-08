package com.spring12.restapi.restcontroller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.service.KakaoPayService;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.pay.KakaoPayApproveRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayApproveResponseVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyRequestVO;
import com.spring12.restapi.vo.pay.KakaoPayReadyResponseVO;

@CrossOrigin
@RestController
@RequestMapping("/kakaopay")
public class KakaoPayRestController {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/ready")
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO request, 
								@RequestHeader("Authorization") String token) throws URISyntaxException {
		request.setPartnerOrderId(UUID.randomUUID().toString());
		MemberClaimVO claimVO 
						= tokenService.check(tokenService.removeBearer(token));
		request.setPartnerUserId(claimVO.getMemberId());
		KakaoPayReadyResponseVO response = 
					kakaoPayService.ready(request);
		return response;
	}
	
	@PostMapping("/approve")
	public KakaoPayApproveResponseVO approve(
			@RequestHeader("Authrization") String token, 
			@RequestBody KakaoPayApproveRequestVO request) throws URISyntaxException {
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
		request.setPartnerUserId(claimVO.getMemberId());//주문자 정보 추가
		KakaoPayApproveResponseVO response = kakaoPayService.approve(request);
		return response;
	}
	
}
