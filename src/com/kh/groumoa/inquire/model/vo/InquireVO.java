package com.kh.groumoa.inquire.model.vo;

import java.sql.Date;

public class InquireVO implements java.io.Serializable{
	private int postCode;
	private String categoryCode;
	private int groupCode;
	private int writerCode;
	private String title;
	private String detail;
	private Date postDate;
	private String status;
	private String categoryName;
	private String memberName;
	private int pcount;
	
	public InquireVO() {}
	
	public InquireVO(int postCode, String categoryCode, int groupCode, int writerCode, String title, String detail,
			Date postDate, String status, String categoryName, String memberName, int pcount) {
		super();
		this.postCode = postCode;
		this.categoryCode = categoryCode;
		this.groupCode = groupCode;
		this.writerCode = writerCode;
		this.title = title;
		this.detail = detail;
		this.postDate = postDate;
		this.status = status;
		this.categoryName = categoryName;
		this.memberName = memberName;
		this.pcount = pcount;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public int getWriterCode() {
		return writerCode;
	}
	public void setWriterCode(int writerCode) {
		this.writerCode = writerCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	@Override
	public String toString() {
		return "InquireVO [postCode=" + postCode + ", categoryCode=" + categoryCode + ", groupCode=" + groupCode
				+ ", writerCode=" + writerCode + ", title=" + title + ", detail=" + detail + ", postDate=" + postDate
				+ ", status=" + status + ", categoryName=" + categoryName + ", memberName=" + memberName + ", pcount="
				+ pcount + "]";
	}

	
}










