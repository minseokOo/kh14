package com.kh.spring06.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDto {
	private String memberId;//아이디
	private String memberPw;//비밀번호
	private String memberNickname;//닉네임
	private String memberBirth;//생년월일
	private String memberContact;//연락처(휴대전화번호)
	private String memberEmail;//이메일
	private String memberLevel;//등급
	private int memberPoint;//보유포인트
	private String memberPost;//우편번호
	private String memberAddress1, memberAddress2;//주소
	private Date memberJoin;//가입일
	private Date memberLogin;//최종로그인 일시
	
}