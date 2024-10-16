package com.spring12.restapi.webSocket.group;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RoomVO {
	private int roomNo;
	private String roomName;
	private Timestamp roomCreated;
	private String join;
}
