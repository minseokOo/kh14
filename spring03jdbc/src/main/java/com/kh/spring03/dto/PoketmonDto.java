package com.kh.spring03.dto;

public class PoketmonDto {
	private int poketmonNo;
	private String poketmonName;
	private String poketmonType;
	
	
	//스프링에서 유일하게 등록하지 않는 클래스 (몇 개가 사용될 지 예상할 수 없음)
	
	@Override
	public String toString() {
		return "PoketmonDto [poketmonNo=" + poketmonNo + ", poketmonName=" + poketmonName + ", poketmonType="
				+ poketmonType + "]";
	}
	public PoketmonDto() {
		super();
	}
	public int getPoketmonNo() {
		return poketmonNo;
	}
	public void setPoketmonNo(int poketmonNo) {
		this.poketmonNo = poketmonNo;
	}
	public String getPoketmonName() {
		return poketmonName;
	}
	public void setPoketmonName(String poketmonName) {
		this.poketmonName = poketmonName;
	}
	public String getPoketmonType() {
		return poketmonType;
	}
	public void setPoketmonType(String poketmonType) {
		this.poketmonType = poketmonType;
	}
}
