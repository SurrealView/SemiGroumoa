package com.kh.groumoa.scheduler.model.vo;

import java.sql.Date;

public class SchedulerVO {
	
	private String schCode;
	private String schTitle;
	private String schDetail;
	private String schDate;
	private String dateWritten;
	private int groupCode;
	private int writerCode;
	
	public SchedulerVO() {
		super();
	}

	public SchedulerVO(String schCode, String schTitle, String schDetail, String schDate, String dateWritten,
			int groupCode, int writerCode) {
		super();
		this.schCode = schCode;
		this.schTitle = schTitle;
		this.schDetail = schDetail;
		this.schDate = schDate;
		this.dateWritten = dateWritten;
		this.groupCode = groupCode;
		this.writerCode = writerCode;
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

	public String getDateWritten() {
		return dateWritten;
	}

	public void setDateWritten(String dateWritten) {
		this.dateWritten = dateWritten;
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


	@Override
	public String toString() {
		return "ScheduleVO [schCode=" + schCode + ", schTitle=" + schTitle + ", schDetail=" + schDetail + ", schDate="
				+ schDate + ", dateWritten=" + dateWritten + ", groupCode=" + groupCode + ", writerCode=" + writerCode
				+ "]";
	}
	
}
