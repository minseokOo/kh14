package com.spring12.restapi.vo;

import lombok.Data;

//로그인에 필요한 정보
@Data
public class MemberLoginRequestVO {
	private String memberId;
	private String memberPw;
	
}
