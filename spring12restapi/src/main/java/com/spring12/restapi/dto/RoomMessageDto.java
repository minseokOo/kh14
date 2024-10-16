package com.spring12.restapi.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RoomMessageDto {
	private int roomMessageNo;
	private String roomMessageType;
	private String roomMessageSender;
	private String roomMessageReceiver;
	private String roomMessageContent;
	private Timestamp roomMessageTime;
	private int roomNo;
}
