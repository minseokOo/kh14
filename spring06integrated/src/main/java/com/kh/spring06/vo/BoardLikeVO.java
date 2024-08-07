package com.kh.spring06.vo;

import lombok.Data;

@Data
public class BoardLikeVO {
	private boolean checked; //좋아요 여부
	private int count; //좋아요 숫자
}
