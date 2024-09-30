package com.spring12.mybatis.vo;

import java.util.List;

import lombok.Data;

//복합검색 요청을 위한 VO
@Data
public class MemberComplexRequestVO {
	private String memberId;
	private String memberNickname;
	private String memberBirth;
	private String memberContact;
	private String memberEmail;
	private List<String> memberLevelList;
	private Integer minMemberPoint;
	private Integer maxMemberPoint;
	private String memberAddress;
	private String beginMemberJoin, endMemberJoin;
	private String beginMemberLogin, endMemberLogin;
	private List<String> orderList;
	private Integer beginRow, endRow;
}
