package jdbc.dto;

public class PoketmonDto {
	private int poketmonNo;
	private String poketmonName;
	private String poketmonType;

	
	public PoketmonDto() {
		super();
	}
	@Override
	public String toString() {
		return "PoketmonDto [poketmonNo=" + poketmonNo + ", poketmonName=" + poketmonName + ", poketmonType="
				+ poketmonType + "]";
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
