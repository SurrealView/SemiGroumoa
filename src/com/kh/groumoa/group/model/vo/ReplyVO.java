package com.kh.groumoa.group.model.vo;

import java.sql.Date;

public class ReplyVO {
	private int replyCode;
	private int postCode;
	private int writerCode;
	private String detail;
	private Date replyDate;
	
	private String writerName;
	
	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ReplyVO(int replyCode, int postCode, int writerCode, String detail, Date replyDate, String writerName) {
		super();
		this.replyCode = replyCode;
		this.postCode = postCode;
		this.writerCode = writerCode;
		this.detail = detail;
		this.replyDate = replyDate;
		this.writerName = writerName;
	}

	

	public String getWriterName() {
		return writerName;
	}



	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}



	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public int getWriterCode() {
		return writerCode;
	}

	public void setWriterCode(int writerCode) {
		this.writerCode = writerCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}



	@Override
	public String toString() {
		return "ReplyVO [replyCode=" + replyCode + ", postCode=" + postCode + ", writerCode=" + writerCode + ", detail="
				+ detail + ", replyDate=" + replyDate + ", writerName=" + writerName + "]";
	}

	
	
	
	
}
