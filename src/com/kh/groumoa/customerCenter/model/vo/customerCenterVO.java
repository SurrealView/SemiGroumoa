package com.kh.groumoa.customerCenter.model.vo;

import java.sql.Date;

public class customerCenterVO {

	int nNo;
	String noticeCode;
	String noticeCategory;
	String noticeTitle;
	String noticeDetail;
	Date noticeDate;
	String mnWriterCode;
	String mnWriterID;
	String noticeStatus;
	
	public customerCenterVO() {}

	public customerCenterVO(int nNo, String noticeCode, String noticeCategory, String noticeTitle, String noticeDetail,
			Date noticeDate, String mnWriterCode, String mnWriterID, String noticeStatus) {
		super();
		this.nNo = nNo;
		this.noticeCode = noticeCode;
		this.noticeCategory = noticeCategory;
		this.noticeTitle = noticeTitle;
		this.noticeDetail = noticeDetail;
		this.noticeDate = noticeDate;
		this.mnWriterCode = mnWriterCode;
		this.mnWriterID = mnWriterID;
		this.noticeStatus = noticeStatus;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getNoticeCategory() {
		return noticeCategory;
	}

	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeDetail() {
		return noticeDetail;
	}

	public void setNoticeDetail(String noticeDetail) {
		this.noticeDetail = noticeDetail;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getMnWriterCode() {
		return mnWriterCode;
	}

	public void setMnWriterCode(String mnWriterCode) {
		this.mnWriterCode = mnWriterCode;
	}

	public String getMnWriterID() {
		return mnWriterID;
	}

	public void setMnWriterID(String mnWriterID) {
		this.mnWriterID = mnWriterID;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	@Override
	public String toString() {
		return "customerCenterVO [nNo=" + nNo + ", noticeCode=" + noticeCode + ", noticeCategory=" + noticeCategory
				+ ", noticeTitle=" + noticeTitle + ", noticeDetail=" + noticeDetail + ", noticeDate=" + noticeDate
				+ ", mnWriterCode=" + mnWriterCode + ", mnWriterID=" + mnWriterID + ", noticeStatus=" + noticeStatus
				+ "]";
	}
	
	
}
