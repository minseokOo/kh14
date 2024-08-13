package com.kh.spring06.vo;

import java.util.List;

import com.kh.spring06.dto.ReplyDto;

import lombok.Data;

@Data
public class ReplyListVO {
	private List<ReplyDto> list;
	private int totalPage;
	private int currentPage;
}
