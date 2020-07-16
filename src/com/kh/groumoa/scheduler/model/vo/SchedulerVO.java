package com.kh.groumoa.scheduler.model.vo;

import java.sql.Date;

public class SchedulerVO {
	
	private String schCode;
	private String schTitle;
	private String schDetail;
	private String schDate;
	private Date dateWritten;
	private String groupCode;
	private int writerCode;
	private char status;
	
	public SchedulerVO() {
		super();
	}

	public SchedulerVO(String schCode, String schTitle, String schDetail, String schDate, Date dateWritten,
			String groupCode, int writerCode, char status) {
		super();
		this.schCode = schCode;
		this.schTitle = schTitle;
		this.schDetail = schDetail;
		this.schDate = schDate;
		this.dateWritten = dateWritten;
		this.groupCode = groupCode;
		this.writerCode = writerCode;
		this.status = status;
	}

	public String getSchCode() {
		return schCode;
	}

	public void setSchCode(String schCode) {
		this.schCode = schCode;
	}

	public String getSchTitle() {
		return schTitle;
	}

	public void setSchTitle(String schTitle) {
		this.schTitle = schTitle;
	}

	public String getSchDetail() {
		return schDetail;
	}

	public void setSchDetail(String schDetail) {
		this.schDetail = schDetail;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate2) {
		this.schDate = schDate2;
	}

	public Date getDateWritten() {
		return dateWritten;
	}

	public void setDateWritten(Date dateWritten) {
		this.dateWritten = dateWritten;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public int getWriterCode() {
		return writerCode;
	}

	public void setWriterCode(int writerCode) {
		this.writerCode = writerCode;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ScheduleVO [schCode=" + schCode + ", schTitle=" + schTitle + ", schDetail=" + schDetail + ", schDate="
				+ schDate + ", dateWritten=" + dateWritten + ", groupCode=" + groupCode + ", writerCode=" + writerCode
				+ ", status=" + status + "]";
	}
	
}
