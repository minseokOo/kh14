package com.spring12.restapi.webSocket.group;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RoomDto {
	private int roomNo;
	private String roomName;
	private Timestamp roomCreated;
	
}
