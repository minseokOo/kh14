package com.spring12.mybatis.vo;

import java.util.List;

import com.spring12.mybatis.dto.MemberDto;

import lombok.Data;

//회원 복합검색의 결과가 저장될 클래스
@Data
public class MemberComplexResponseVO {

	private List<MemberDto> memberList; // 검색 결과
	private boolean isList; // 다음 항목이 존재하는가
	
}
