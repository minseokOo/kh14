package com.spring12.restapi.vo.pay;

import lombok.Data;

@Data
public class KakaoPayApproveRequestVO {
	private String partnerOrderId;
	private String partnerUserId;
	private String tid;
	private String pgToken;
}
