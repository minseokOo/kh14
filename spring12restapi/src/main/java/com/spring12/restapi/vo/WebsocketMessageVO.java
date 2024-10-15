package com.spring12.restapi.vo;

import java.time.LocalDateTime;

import lombok.Data;

//DB에서 불러온 메세지를 저장할 VO
@Data
public class WebsocketMessageVO {
	private final String type;
	private String senderMemberId;//발신자
	private String senderMemberLevel;
	private String receiverMemberId;//수신자
	private String content;
	private LocalDateTime time;
}
