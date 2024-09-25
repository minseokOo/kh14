package com.spring12.restapi.vo;

import lombok.Data;

//VO (Value Object)
// - DTO로 표현하기 힘든 변형된 데이터를 담기 위한 객체
@Data
public class StatusVO {
	private String title;
	private int cnt;
}
