package com.spring12.restapi.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentDto {
	private int paymentNo;
	private String paymentTid;
	private String paymentName;
	private int paymentTotal;
	private int paymentRemain;
	private String memberId;
	private Date paymentTime;
}
