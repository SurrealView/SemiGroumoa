package com.kh.groumoa.answer.manager.model.vo;

import java.sql.Date;

public class AnswerVo {
	/*QNA_CODE	VARCHAR2(5 BYTE)
	QUESTIONER_CODE	NUMBER
	QNA_CATE_CODE	VARCHAR2(5 BYTE)
	QNA_TITLE	VARCHAR2(60 BYTE)
	QNA_DETAIL	VARCHAR2(750 BYTE)
	QNA_DATE	DATE
	QNA_REPLY	VARCHAR2(1000 BYTE)
	REPLIER_CODE	VARCHAR2(5 BYTE)*/
	
	String qnaCode;
	int questionerCode;
	String qnaCateCode;
	String qnaTitle;
	String qnaDetail;
	Date qnaDate;
	String qnaReply;
	String replierCode;
	String isAnswered;
	
	public AnswerVo() {
		
	}
	
	public AnswerVo(String qnaCode, int questionerCode, String qnaCateCode, String qnaTitle, String qnaDetail,
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

	public int getQuestionerCode() {
		return questionerCode;
	}

	public void setQuestionerCode(int questionerCode) {
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
	
	public String getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(String isAnswered) {
		this.isAnswered = isAnswered;
	}

	@Override
	public String toString() {
		return "AnswerVo [qnaCode=" + qnaCode + ", questionerCode=" + questionerCode + ", qnaCateCode=" + qnaCateCode
				+ ", qnaTitle=" + qnaTitle + ", qnaDetail=" + qnaDetail + ", qnaDate=" + qnaDate + ", qnaReply="
				+ qnaReply + ", replierCode=" + replierCode + "]";
	}	
}
