package com.kh.groumoa.member.model.vo;

public class PenaltyTypeVO implements java.io.Serializable {
	private String ptCode;
	private String ptName;
	
	public PenaltyTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PenaltyTypeVO(String ptCode, String ptName) {
		super();
		this.ptCode = ptCode;
		this.ptName = ptName;
	}
	public String getPtCode() {
		return ptCode;
	}
	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}
	public String getPtName() {
		return ptName;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	@Override
	public String toString() {
		return "PenaltyTypeVO [ptCode=" + ptCode + ", ptName=" + ptName + "]";
	}
	
	
}
