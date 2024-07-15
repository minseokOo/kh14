package com.kh.spring06.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	//메소드 추가
	public String getBoardWriterString() {
		if(boardWriter == null) return "탈퇴한 사용자";
		return boardWriter;
	}
	
	//날짜 출력 형식 메소드
	// - 우리가 가진 시간은 java.sql.Date 형식
	// - 배운 기술 중 가장 세련된 기술은 java.time 패키지
	// - java.sql.Date는 LocalDate로 쉽게 변환이 가능
	// - java.sql.Timestamp는 LocalDateTime으로 쉽게 변환이 가능
	public String getBoardWtimeString() {
		Timestamp stamp = new Timestamp(boardWtime.getTime());
		LocalDateTime time = stamp.toLocalDateTime();
		LocalDate today = LocalDate.now();
		
		if(time.toLocalDate().equals(today)) {
		return time.format(DateTimeFormatter.ofPattern("HH:mm")); //시간
		}
		else {
		return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));	} //날짜
	}
}
