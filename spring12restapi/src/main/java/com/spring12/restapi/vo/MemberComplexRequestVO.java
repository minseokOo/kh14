package com.spring12.restapi.vo;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring12.mybatis.advice.JsonEmptyStringToNullDeserializer;

import lombok.Data;

//복합검색 요청을 위한 VO
@Data
public class MemberComplexRequestVO {
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String memberId;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String memberNickname;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String memberBirth;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String memberContact;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String memberEmail;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private Integer minMemberPoint;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private Integer maxMemberPoint;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String memberAddress;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String beginMemberJoin, endMemberJoin;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private String beginMemberLogin, endMemberLogin;
	@JsonDeserialize(using = JsonEmptyStringToNullDeserializer.class)
	private Integer beginRow, endRow;
	private List<String> memberLevelList;
	private List<String> orderList;
}
