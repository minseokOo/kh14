package com.kh.spring06.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReplyDto {

	private int replyNo;
	private String replyWriter;
	private int replyOrigin;
	private String replyContent;
	//프론트엔드로 전송할 때(JSON으로 변환할 때) 시간도 포함되도록 설정
	// -> JSON 변환 라이브러리인 Jackson에서 제공하는 기능
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date replyWtime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Seoul")
	private Date replyUtime;
}
