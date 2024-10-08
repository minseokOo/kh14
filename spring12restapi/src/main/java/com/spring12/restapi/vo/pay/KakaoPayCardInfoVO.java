package com.spring12.restapi.vo.pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPayCardInfoVO {
	private String kakaopayPurchaseCorp;//카카오페이 매입사명
	private String kakaopayPurchasedCorpCode;//카카오페이 매입사 코드
	private String kakaopayIssuerCorp;//카카오페이 발급사명
	private String kakaopayIssuerCorpCode;//카카오페이 발급사 코드
	private String bin;//카드 BIN
	private String cardType;//카드 타입
	private String installMonth;//할부 개월 수
	private String approvedId;//카드사 승인 번호
	private String cardMid;//카드사 가맹점 번호
	private String interestFreeInstall;//무이자 할부 번호
	private String installmentType;
	private String cardItemCode;
}
