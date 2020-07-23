package com.kh.groumoa.inquire.model.vo;

import java.sql.Date;

public class InquireVO implements java.io.Serializable{
	
	/*QNA_CODE
	QUESTIONER_CODE
	QNA_CATE_CODE
	QNA_TITLE
	QNA_DETAIL
	QNA_DATE
	QNA_REPLY
	REPLIER_CODE*/
	
	private String qnaCode;
	private String questionerCode;
	private String qnaCateCode;
	private String qnaTitle;
	private String qnaDetail;
	private Date qnaDate;
	private String qnaReply;
	private String replierCode;
	
	public InquireVO() {}

	public InquireVO(String qnaCode, String questionerCode, String qnaCateCode, String qnaTitle, String qnaDetail,
			Date qnaDate, String qnaReply, String replierCode) {
		super();
		this.qnaCode = qnaCode;
		this.questionerCode = questionerCode;
		this.qnaCateCode = qnaCateCode;
		this.qnaTitle = qnaTitle;
		this.qnaDetail = qnaDetail;
		this.qnaDate = qnaDate;
		this.qnaReply = qnaReply;
		this.replierCode = replierCode;
	}

	public String getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getQuestionerCode() {
		return questionerCode;
	}

	public void setQuestionerCode(String questionerCode) {
		this.questionerCode = questionerCode;
	}

	public String getQnaCateCode() {
		return qnaCateCode;
	}

	public void setQnaCateCode(String qnaCateCode) {
		this.qnaCateCode = qnaCateCode;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaDetail() {
		return qnaDetail;
	}

	public void setQnaDetail(String qnaDetail) {
		this.qnaDetail = qnaDetail;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaReply() {
		return qnaReply;
	}

	public void setQnaReply(String qnaReply) {
		this.qnaReply = qnaReply;
	}

	public String getReplierCode() {
		return replierCode;
	}

	public void setReplierCode(String replierCode) {
		this.replierCode = replierCode;
	}

	@Override
	public String toString() {
		return "InquireVO [qnaCode=" + qnaCode + ", questionerCode=" + questionerCode + ", qnaCateCode=" + qnaCateCode
				+ ", qnaTitle=" + qnaTitle + ", qnaDetail=" + qnaDetail + ", qnaDate=" + qnaDate + ", qnaReply="
				+ qnaReply + ", replierCode=" + replierCode + "]";
	}
	

}










