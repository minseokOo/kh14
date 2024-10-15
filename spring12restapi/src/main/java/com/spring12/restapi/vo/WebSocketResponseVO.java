package com.spring12.restapi.vo;

import java.time.LocalDateTime;

import lombok.Data;

//사용자에게 보낼 내용을 저장하기 위한 VO
@Data
public class WebSocketResponseVO {
	private final String type = "chat";
	private String senderMemberId;
	private String senderMemberLevel;
	private String content;
	private LocalDateTime time;
}
