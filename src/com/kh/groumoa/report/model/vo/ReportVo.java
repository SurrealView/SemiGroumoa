package com.kh.groumoa.report.model.vo;

import java.sql.Date;

public class ReportVo {
	String reportCode;
	int reporter;
	int reported;
	String reporterID;
	String reportedID;
	String reportCategory;
	Date reportDate;
	String reportTitle;
	String reportDetail;
	String isDealt;
	int rno;
	
	public ReportVo() {
		
	}	
	
	public ReportVo(String reportCode, int reporter, int reported, String reportCategory, Date reportDate,
			String reportTitle, String reportDetail, String isDealt) {
		super();
		this.reportCode = reportCode;
		this.reporter = reporter;
		this.reported = reported;
		this.reportCategory = reportCategory;
		this.reportDate = reportDate;
		this.reportTitle = reportTitle;
		this.reportDetail = reportDetail;
		this.isDealt = isDealt;
	}
	
	

	public int getRno() {
		return rno;
	}

	public void setRno(String reportCode) {
		rno = Integer.parseInt(reportCode.replace("RE", ""));
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public int getReporter() {
		return reporter;
	}

	public void setReporter(int reporter) {
		this.reporter = reporter;
	}

	public int getReported() {
		return reported;
	}

	public void setReported(int reported) {
		this.reported = reported;
	}

	public String getReportCategory() {
		return reportCategory;
	}

	public void setReportCategory(String reportCategory) {
		this.reportCategory = reportCategory;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportDetail() {
		return reportDetail;
	}

	public void setReportDetail(String reportDetail) {
		this.reportDetail = reportDetail;
	}

	public String getIsDealt() {
		return isDealt;
	}

	public void setIsDealt(String isDealt) {
		this.isDealt = isDealt;
	}
	
	public String getReporterID() {
		return reporterID;
	}

	public void setReporterID(String reporterID) {
		this.reporterID = reporterID;
	}

	public String getReportedID() {
		return reportedID;
	}

	public void setReportedID(String reportedID) {
		this.reportedID = reportedID;
	}

	@Override
	public String toString() {
		return "ReportVo [reportCode=" + reportCode + ", reporter=" + reporter + ", reported=" + reported
				+ ", reportCategory=" + reportCategory + ", reportDate=" + reportDate + ", reportTitle=" + reportTitle
				+ ", reportDetail=" + reportDetail + ", isDealt=" + isDealt + "]";
	}
	
}
