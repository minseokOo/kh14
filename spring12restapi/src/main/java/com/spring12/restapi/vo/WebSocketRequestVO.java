package com.spring12.restapi.vo;

import lombok.Data;

//사용자가 보내는 내용을 수신하기 위한 VO
@Data
public class WebSocketRequestVO {
	private String content;
}
