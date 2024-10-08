package com.spring12.restapi.vo.pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPayAmountVO {
	private int total;//전체금액
	private int taxFree;//비과세
	private int vat;//부가세
	private int point;//포인트 사용 금액
	private int discount;//할인 금액
	private int greenDeposit;//컵 보증금

}
