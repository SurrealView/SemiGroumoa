package com.kh.groumoa.group.model.vo;

import java.sql.Date;

public class BoardVO implements java.io.Serializable {
	private String postCode;
	private String categoryCode;
	private String groupCode;
	private int writerCode;//만약 string으로 바뀐다면 수정
	private String title;
	private String detail;
	private Date postDate;
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardVO(String postCode, String categoryCode, String groupCode, int writerCode, String title, String detail,
			Date postDate) {
		super();
		this.postCode = postCode;
		this.categoryCode = categoryCode;
		this.groupCode = groupCode;
		this.writerCode = writerCode;
		this.title = title;
		this.detail = detail;
		this.postDate = postDate;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
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

	@Override
	public String toString() {
		return "BoardVO [postCode=" + postCode + ", categoryCode=" + categoryCode + ", groupCode=" + groupCode
				+ ", writerCode=" + writerCode + ", title=" + title + ", detail=" + detail + ", postDate=" + postDate
				+ "]";
	}
	
	
}
