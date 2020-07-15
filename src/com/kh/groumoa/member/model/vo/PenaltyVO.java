package com.kh.groumoa.member.model.vo;

import java.sql.Date;

public class PenaltyVO implements java.io.Serializable {
	private String penaltyCode;
	private String ptCode;
	private String penaltyReason;
	private int MemberCode;
	private Date penaltyDate;
	
	public PenaltyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PenaltyVO(String penaltyCode, String ptCode, String penaltyReason, int memberCode, Date penaltyDate) {
		super();
		this.penaltyCode = penaltyCode;
		this.ptCode = ptCode;
		this.penaltyReason = penaltyReason;
		MemberCode = memberCode;
		this.penaltyDate = penaltyDate;
	}
	public String getPenaltyCode() {
		return penaltyCode;
	}
	public void setPenaltyCode(String penaltyCode) {
		this.penaltyCode = penaltyCode;
	}
	public String getPtCode() {
		return ptCode;
	}
	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}
	public String getPenaltyReason() {
		return penaltyReason;
	}
	public void setPenaltyReason(String penaltyReason) {
		this.penaltyReason = penaltyReason;
	}
	public int getMemberCode() {
		return MemberCode;
	}
	public void setMemberCode(int memberCode) {
		MemberCode = memberCode;
	}
	public Date getPenaltyDate() {
		return penaltyDate;
	}
	public void setPenaltyDate(Date penaltyDate) {
		this.penaltyDate = penaltyDate;
	}
	
	@Override
	public String toString() {
		return "PenaltyVO [penaltyCode=" + penaltyCode + ", ptCode=" + ptCode + ", penaltyReason=" + penaltyReason
				+ ", MemberCode=" + MemberCode + ", penaltyDate=" + penaltyDate + "]";
	}
	
}
