package com.kh.groumoa.fee.model.vo;

public class FeeVO {
	private int feeCode;
	private int groupCode;
	private int memberCode;
	private String feeCategory;
	private String fee;
	private String detail;
	private String feeDate;
	//-- 단일 TB_FEE에 있는 변수들.
	
	public FeeVO() { }

	public FeeVO(int feeCode,int groupCode, int memberCode, String feeCategory, String fee, String detail, String feeDate) {
		super();
		this.feeCode = feeCode;
		this.groupCode = groupCode;
		this.memberCode = memberCode;
		this.feeCategory = feeCategory;
		this.fee = fee;
		this.detail = detail;
		this.feeDate = feeDate;
	}
	

	public int getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(int feeCode) {
		this.feeCode = feeCode;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
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
		return "FeeVO [feeCode=" + feeCode + ", groupCode=" + groupCode + ", memberCode=" + memberCode
				+ ", feeCategory=" + feeCategory + ", fee=" + fee + ", detail=" + detail + ", feeDate=" + feeDate + "]";
	}

	
}
