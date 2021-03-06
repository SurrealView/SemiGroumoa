package com.kh.groumoa.member.model.vo;

import java.sql.Date;

public class MemberVO implements java.io.Serializable {
	private int memberCode;
	private String email;
	private String userName;
	private String userPwd;
	private String gender;
	private String rnCode;
	private String address;
	private String phone;
	private String birthDate;
	private Date enrollDate;
	private String status;
	
	
	//GroupMember 관련 
	private int groupCode;
	private String groupLeaderyn;
	
	//GroupMember 회원 번호 추가
	private int num;
	
	//Member 글 작성 횟수
	private int postCode;
	
	//회원 정보
	private String groupName;
	private int penaltyCode;
	private int groupLeaderCode;
	private int question;
	private int reply;
	
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MemberVO(int memberCode, String email, String userName, String userPwd, String gender, String rnCode,
			String address, String phone, String birthDate, Date enrollDate, String status, int groupCode,
			String groupLeaderyn, int num, int postCode, String groupName, int penaltyCode, int groupLeaderCode,
			int question, int reply) {
		super();
		this.memberCode = memberCode;
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.gender = gender;
		this.rnCode = rnCode;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.enrollDate = enrollDate;
		this.status = status;
		this.groupCode = groupCode;
		this.groupLeaderyn = groupLeaderyn;
		this.num = num;
		this.postCode = postCode;
		this.groupName = groupName;
		this.penaltyCode = penaltyCode;
		this.groupLeaderCode = groupLeaderCode;
		this.question = question;
		this.reply = reply;
	}


	public int getMemberCode() {
		return memberCode;
	}


	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRnCode() {
		return rnCode;
	}


	public void setRnCode(String rnCode) {
		this.rnCode = rnCode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
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


	public String getGroupLeaderyn() {
		return groupLeaderyn;
	}


	public void setGroupLeaderyn(String groupLeaderyn) {
		this.groupLeaderyn = groupLeaderyn;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public int getPenaltyCode() {
		return penaltyCode;
	}


	public void setPenaltyCode(int penaltyCode) {
		this.penaltyCode = penaltyCode;
	}


	public int getGroupLeaderCode() {
		return groupLeaderCode;
	}


	public void setGroupLeaderCode(int groupLeaderCode) {
		this.groupLeaderCode = groupLeaderCode;
	}


	public int getQuestion() {
		return question;
	}


	public void setQuestion(int question) {
		this.question = question;
	}


	public int getReply() {
		return reply;
	}


	public void setReply(int reply) {
		this.reply = reply;
	}


	@Override
	public String toString() {
		return "MemberVO [memberCode=" + memberCode + ", email=" + email + ", userName=" + userName + ", userPwd="
				+ userPwd + ", gender=" + gender + ", rnCode=" + rnCode + ", address=" + address + ", phone=" + phone
				+ ", birthDate=" + birthDate + ", enrollDate=" + enrollDate + ", status=" + status + ", groupCode="
				+ groupCode + ", groupLeaderyn=" + groupLeaderyn + ", num=" + num + ", postCode=" + postCode
				+ ", groupName=" + groupName + ", penaltyCode=" + penaltyCode + ", groupLeaderCode=" + groupLeaderCode
				+ ", question=" + question + ", reply=" + reply + "]";
	}

}
