package com.kh.groumoa.member.model.vo;

import java.sql.Date;

public class MemberVO {
	private int memberCode;
	private String email;
	private String userName;
	private String userPwd;
	private String gender;
	private String rnCode;
	private String address;
	private String phone;
	private Date birthDate;
	private Date enrollDate;
	private String status;
	
	
	
	
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	



	public MemberVO(int memberCode, String email, String userName, String userPwd, String gender, String rnCode,
			String address, String phone, Date birthDate, Date enrollDate, String status) {
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
	}
	
	






	public String getUserPwd() {
		return userPwd;
	}







	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
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







	@Override
	public String toString() {
		return "MemberVO [memberCode=" + memberCode + ", email=" + email + ", userName=" + userName + ", userPwd="
				+ userPwd + ", gender=" + gender + ", rnCode=" + rnCode + ", address=" + address + ", phone=" + phone
				+ ", birthDate=" + birthDate + ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}



	
	
	
	
}
