package com.kh.groumoa.notice.model.vo;

import java.sql.Date;

public class NoticeVo {
	/*NOTICE_CODE	VARCHAR2(5 BYTE)
	NOTICE_CATEGORY	VARCHAR2(15 BYTE)
	NOTICE_TITLE	VARCHAR2(60 BYTE)
	NOTICE_DETAIL	VARCHAR2(3000 BYTE)
	NOTICE_DATE	DATE
	MN_WRITER_CODE	VARCHAR2(5 BYTE)
	NOTICE_STATUS	CHAR(1 BYTE)*/
	
	String noticeCode;
	String noticeCategory;
	String noticeTitle;
	String noticeDetail;
	Date noticeDate;
	String mnWriterCode;
	String noticeStatus;
	
	public NoticeVo() {
		
	}
	
	public NoticeVo(String noticeCode, String noticeCategory, String noticeTitle, String noticeDetail, Date noticeDate,
			String mnWriterCode, String noticeStatus) {
		super();
		this.noticeCode = noticeCode;
		this.noticeCategory = noticeCategory;
		this.noticeTitle = noticeTitle;
		this.noticeDetail = noticeDetail;
		this.noticeDate = noticeDate;
		this.mnWriterCode = mnWriterCode;
		this.noticeStatus = noticeStatus;
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

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	@Override
	public String toString() {
		return "NoticeVo [noticeCode=" + noticeCode + ", noticeCategory=" + noticeCategory + ", noticeTitle="
				+ noticeTitle + ", noticeDetail=" + noticeDetail + ", noticeDate=" + noticeDate + ", mnWriterCode="
				+ mnWriterCode + ", noticeStatus=" + noticeStatus + "]";
	}
	
	
}
