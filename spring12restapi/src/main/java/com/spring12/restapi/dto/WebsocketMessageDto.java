package com.spring12.restapi.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class WebsocketMessageDto {
	private int websocketMessageNo;
	private String websocketMessageType;
	private String websocketMessageSender;
	private String websocketMessageReceiver;
	private String websocketMessageContent;
	private Timestamp websocketMessageTime;
}
