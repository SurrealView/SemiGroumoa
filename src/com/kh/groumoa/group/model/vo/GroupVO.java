package com.kh.groumoa.group.model.vo;

import java.sql.Date;

public class GroupVO implements java.io.Serializable {
	
	private String groupCode;
	private String groupName;
	private String rnCode;
	private String interestCode;
	private String nickNameyn;
	private String openYn;
	private Date openDate;
	private String groupRule;
	private String description;
	
	
	public GroupVO() {}


	public GroupVO(String groupCode, String groupName, String rnCode, String interestCode, String nickNameyn,
			String openYn, Date openDate, String groupRule, String description) {
		super();
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.rnCode = rnCode;
		this.interestCode = interestCode;
		this.nickNameyn = nickNameyn;
		this.openYn = openYn;
		this.openDate = openDate;
		this.groupRule = groupRule;
		this.description = description;
	}


	public String getGroupCode() {
		return groupCode;
	}


	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getRnCode() {
		return rnCode;
	}


	public void setRnCode(String rnCode) {
		this.rnCode = rnCode;
	}


	public String getInterestCode() {
		return interestCode;
	}


	public void setInterestCode(String interestCode) {
		this.interestCode = interestCode;
	}


	public String getNickNameyn() {
		return nickNameyn;
	}


	public void setNickNameyn(String nickNameyn) {
		this.nickNameyn = nickNameyn;
	}


	public String getOpenYn() {
		return openYn;
	}


	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}


	public Date getOpenDate() {
		return openDate;
	}


	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}


	public String getGroupRule() {
		return groupRule;
	}


	public void setGroupRule(String groupRule) {
		this.groupRule = groupRule;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "GroupVO [groupCode=" + groupCode + ", groupName=" + groupName + ", rnCode=" + rnCode + ", interestCode="
				+ interestCode + ", nickNameyn=" + nickNameyn + ", openYn=" + openYn + ", openDate=" + openDate
				+ ", groupRule=" + groupRule + ", description=" + description + "]";
	}

}
