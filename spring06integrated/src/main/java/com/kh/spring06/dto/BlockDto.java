package com.kh.spring06.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BlockDto {
	private int blockNo;
	private String blockType;
	private String blockMemo;
	private Date blockTime;
	private String blockTarget;//회원 ID(외래키, FK)
}
