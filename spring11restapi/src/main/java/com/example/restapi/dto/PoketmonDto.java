package com.example.restapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter @Getter
//@NoArgsConstructor @ToString
@Data
public class PoketmonDto {
	
	private int poketmonNo;
	private String poketmonName;
	private String poketmonType;
	
	
	//스프링에서 유일하게 등록하지 않는 클래스 (몇 개가 사용될 지 예상할 수 없음)
}
