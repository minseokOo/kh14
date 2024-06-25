package jdbc.util;

public class EmpDto {
	private int empNo;
	private String empName;
	private String empDept;
	private String empDate;
	private String empRank;
	private int empSal;
	
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpDate() {
		return empDate;
	}
	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}
	public String getEmpRank() {
		return empRank;
	}
	public void setEmpRank(String empRank) {
		this.empRank = empRank;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
}
