package com.kh.spring06.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDto {

	private int replyNo;
	private String replyWriter;
	private int replyOrigin;
	private String replyContent;
	private Date replyWtime;
	private Date replyUtime;
}
