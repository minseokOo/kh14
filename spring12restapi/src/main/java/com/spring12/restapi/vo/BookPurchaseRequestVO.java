package com.spring12.restapi.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookPurchaseRequestVO {
	private List<BookQtyVO> bookList;
	private String approvalUrl;
	private String cancelUrl;
	private String failUrl;
}
