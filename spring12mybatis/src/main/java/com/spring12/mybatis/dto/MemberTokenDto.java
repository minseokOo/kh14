package com.spring12.mybatis.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberTokenDto {
	private int tokenNo;
	private String tokenTarget;
	private String tokenValue;
	private Date tokenTime;
}