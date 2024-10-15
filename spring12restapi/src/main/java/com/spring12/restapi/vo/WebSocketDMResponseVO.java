package com.spring12.restapi.vo;

import java.time.LocalDateTime;

import lombok.Data;

//사용자에게 보낼 DM메세지를 저장할 VO
@Data
public class WebSocketDMResponseVO {
	private final String type = "dm";
	private String senderMemberId;//발신자
	private String senderMemberLevel;
	private String receiverMemberId;//수신자
	private String content;
	private LocalDateTime time;
}
