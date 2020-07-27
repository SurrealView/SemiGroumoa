package com.kh.groumoa.member.model.vo;

import java.util.Date;

public class ManagerVO {
	private String managerCode;
	private String managerName;
	private String managerId;
	private String managerPwd;
	
	private String noticeCode;
	
	public ManagerVO() {}

	public ManagerVO(String managerCode, String managerName, String managerId, String managerPwd, String noticeCode) {
		super();
		this.managerCode = managerCode;
		this.managerName = managerName;
		this.managerId = managerId;
		this.managerPwd = managerPwd;
		this.noticeCode = noticeCode;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

	@Override
	public String toString() {
		return "ManagerVO [managerCode=" + managerCode + ", managerName=" + managerName + ", managerId=" + managerId
				+ ", managerPwd=" + managerPwd + ", noticeCode=" + noticeCode + "]";
	}
	
}
