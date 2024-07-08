package com.kh.spring06.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDto {

	public String memberId;
	public String memberPw;
	public String memberNick;
	public String memberBirth;
	public String memberContact;
	public String memberEmail;
	public String memberLevel;
	public int memberPoint;
	public String memberPost;
	public String memberAddress1;
	public String memberAddress2;
	public Date memberJoin;
	public Date memberLogin;
}
