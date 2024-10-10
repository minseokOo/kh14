package com.spring12.restapi.vo;

import java.util.List;

import com.spring12.restapi.dto.PaymentDetailDto;
import com.spring12.restapi.dto.PaymentDto;

import lombok.Data;

@Data
public class PaymentTotalVO {
	private PaymentDto paymentDto;
	private List<PaymentDetailDto> paymentDetailList;
}
