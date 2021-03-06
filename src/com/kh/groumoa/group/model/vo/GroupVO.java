package com.kh.groumoa.group.model.vo;

import java.sql.Date;

public class GroupVO implements java.io.Serializable {
	
	private int groupCode;
	private String groupName;
	private String rnCode;
	private String interestCode;
	private String nickNameyn;
	private String openYn;
	private Date openDate;
	private String groupRule;
	private String description;
	private String status;
	private int groupLeaderCode;
	
	//내 동호회페이지 받아오기 위한 변수
	private String groupLeaderYn;
	private String regionName;
	private String interest;
	private String groupLeaderName;
	
	//관리자 페이지 동호회 리스트
	private int memberCount;
	private int postCount;
	private String memberName;
	
	//관리자 페이지 동호회 상세 보기
	private String email;
	private String phone;
	
	public GroupVO() {}

	public GroupVO(int groupCode, String groupName, String rnCode, String interestCode, String nickNameyn,
			String openYn, Date openDate, String groupRule, String description, String status, int groupLeaderCode,
			String groupLeaderYn, String regionName, String interest, String groupLeaderName, int memberCount,
			int postCount, String memberName, String email, String phone) {
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
		this.status = status;
		this.groupLeaderCode = groupLeaderCode;
		this.groupLeaderYn = groupLeaderYn;
		this.regionName = regionName;
		this.interest = interest;
		this.groupLeaderName = groupLeaderName;
		this.memberCount = memberCount;
		this.postCount = postCount;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGroupLeaderCode() {
		return groupLeaderCode;
	}

	public void setGroupLeaderCode(int groupLeaderCode) {
		this.groupLeaderCode = groupLeaderCode;
	}

	public String getGroupLeaderYn() {
		return groupLeaderYn;
	}

	public void setGroupLeaderYn(String groupLeaderYn) {
		this.groupLeaderYn = groupLeaderYn;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getGroupLeaderName() {
		return groupLeaderName;
	}

	public void setGroupLeaderName(String groupLeaderName) {
		this.groupLeaderName = groupLeaderName;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "GroupVO [groupCode=" + groupCode + ", groupName=" + groupName + ", rnCode=" + rnCode + ", interestCode="
				+ interestCode + ", nickNameyn=" + nickNameyn + ", openYn=" + openYn + ", openDate=" + openDate
				+ ", groupRule=" + groupRule + ", description=" + description + ", status=" + status
				+ ", groupLeaderCode=" + groupLeaderCode + ", groupLeaderYn=" + groupLeaderYn + ", regionName="
				+ regionName + ", interest=" + interest + ", groupLeaderName=" + groupLeaderName + ", memberCount="
				+ memberCount + ", postCount=" + postCount + ", memberName=" + memberName + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	

}