package com.spring12.restapi.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookQtyVO {
	private int bookId;
	private int qty;

}
