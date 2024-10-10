package com.spring12.restapi.dto;

import lombok.Data;

@Data
public class PaymentDetailDto {
	private int paymentDetailNo;
	private String paymentDetailName;
	private int paymentDetailPrice;
	private int paymentDetailQty;
	private int paymentDetailItem;
	private int paymentDetailOrigin;
	private String paymentDetailStatus;
}
