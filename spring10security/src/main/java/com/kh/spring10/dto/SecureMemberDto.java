package com.kh.spring10.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SecureMemberDto {

	private String memberId;
	private String memberPw;
	private String memberNick;
	private Date memberJoin;
}
