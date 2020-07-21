package com.kh.groumoa.fee.model.vo;

public class FeeVO {
	private int groupCode;
	private int memberCode;
	private String feeDate;
	private String feeCategory;
	private String detail;
	
	public FeeVO() { }

	public FeeVO(int groupCode, int memberCode, String feeDate, String feeCategory, String detail) {
		super();
		this.groupCode = groupCode;
		this.memberCode = memberCode;
		this.feeDate = feeDate;
		this.feeCategory = feeCategory;
		this.detail = detail;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}

	public String getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(String feeCategory) {
		this.feeCategory = feeCategory;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "FeeVO [groupCode=" + groupCode + ", memberCode=" + memberCode + ", feeDate=" + feeDate
				+ ", feeCategory=" + feeCategory + ", detail=" + detail + "]";
	}
}
