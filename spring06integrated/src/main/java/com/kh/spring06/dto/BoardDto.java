package com.kh.spring06.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDto {
	public int boardNo;
	public String boardTitle;
	public String boardContent;
	public String boardWriter;
	public Date boardWtime;
	public Date boardUtime;
	public int boardViews;
	public int boardLikes;
	public int boardReplies;
}
