package com.kh.spring03.dto;

public class EmpDto {
	
	private int empNo;
	private String empName;
	private String empDept;
	private String empDate;
	private String empRank;
	private int empSal;
	
	
	
	@Override
	public String toString() {
		return "EmpDto [empNo=" + empNo + ", empName=" + empName + ", empDept=" + empDept + ", empDate=" + empDate
				+ ", empRank=" + empRank + ", empSal=" + empSal + "]";
	}
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
