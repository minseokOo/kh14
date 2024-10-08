package com.spring12.restapi.vo;

import java.util.List;

import com.spring12.restapi.dto.MemberDto;

import lombok.Data;

//회원 복합검색의 결과가 저장될 클래스
@Data
public class MemberComplexResponseVO {

	private boolean last; // 다음 항목이 존재하는가
	private int count; // 개수는 몇개인가
	private List<MemberDto> memberList; // 검색 결과
	
}
