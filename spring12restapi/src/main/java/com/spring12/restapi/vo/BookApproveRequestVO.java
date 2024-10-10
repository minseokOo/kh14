package com.spring12.restapi.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookApproveRequestVO {
	private String partnerOrderId;
	private String tid;
	private String pgToken;
	private List<BookQtyVO> bookList;
}
