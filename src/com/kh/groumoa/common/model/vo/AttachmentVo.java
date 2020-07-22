package com.kh.groumoa.common.model.vo;

import java.sql.Date;

public class AttachmentVo {
	
	private String fid;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int fileLevel;
	private String status;
	private int groupCode;
	private String noticeCode;
	private String qnaCode;
	private int postCode;
	private String reportCode;
	
	public AttachmentVo() {
		
	}

	public AttachmentVo(String fid, String originName, String changeName, String filePath, Date uploadDate,
			int fileLevel, String status, int groupCode, String noticeCode, String qnaCode, int postCode,
			String reportCode) {
		super();
		this.fid = fid;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.status = status;
		this.groupCode = groupCode;
		this.noticeCode = noticeCode;
		this.qnaCode = qnaCode;
		this.postCode = postCode;
		this.reportCode = reportCode;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	@Override
	public String toString() {
		return "AttachmentVo [fid=" + fid + ", originName=" + originName + ", changeName=" + changeName + ", filePath="
				+ filePath + ", uploadDate=" + uploadDate + ", fileLevel=" + fileLevel + ", status=" + status
				+ ", groupCode=" + groupCode + ", noticeCode=" + noticeCode + ", qnaCode=" + qnaCode + ", postCode="
				+ postCode + ", reportCode=" + reportCode + "]";
	}
		
}
