package com.kh.groumoa.member.model.vo;

public class MemberInterestVO implements java.io.Serializable{
	private int memberCode;
	private String interestCode;
	
	public MemberInterestVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberInterestVO(int memberCode, String interestCode) {
		super();
		this.memberCode = memberCode;
		this.interestCode = interestCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getInterestCode() {
		return interestCode;
	}

	public void setInterestCode(String interestCode) {
		this.interestCode = interestCode;
	}

	@Override
	public String toString() {
		return "InterestMemberVO [memberCode=" + memberCode + ", interestCode=" + interestCode + "]";
	}
	
	
}
