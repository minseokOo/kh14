package com.kh.spring06.vo;

import java.sql.Date;

import lombok.Data;

//회원과 차단 정보가 같이 담길 수 있는 VO (관리자 회원 검색 시 사용)
@Data
public class MemberBlockVO {
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
		
		private int blockNo;
		private String blockType;
		private String blockMemo;
		private Date blockTime;
		private String blockTarget;//회원 ID(외래키, FK)
}
