package com.kh.groumoa.member.model.vo;

public class InterestVO implements java.io.Serializable {
	
	private String interestCode;
	private String interest;
	
	public InterestVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InterestVO(String interestCode, String interest) {
		super();
		this.interestCode = interestCode;
		this.interest = interest;
	}

	public String getInterestCode() {
		return interestCode;
	}

	public void setInterestCode(String interestCode) {
		this.interestCode = interestCode;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "InterestVO [interestCode=" + interestCode + ", interest=" + interest + "]";
	}
	
	
	
	
}
