package com.spring12.restapi.vo.pay;

import lombok.Data;

//카카오 페이 준비 요청 데이터
@Data
public class KakaoPayReadyRequestVO {
	private String partnerOrderId;
	private String partnerUserId;
	private String ItemName;
	private int totalAmount;

}
