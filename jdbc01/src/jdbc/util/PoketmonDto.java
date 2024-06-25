package jdbc.util;


// DTO(Data Transfer Object)
// - 변환용 객체(포장상자)
// - 데이터베이스와 동일하게 만듦(언더바 대신 카멜케이스)
public class PoketmonDto {
	private int poketmonNo;
	private String poketmonName;
	private String poketmonType;
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
