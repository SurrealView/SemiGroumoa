package com.kh.groumoa.payment.model.vo;

import java.sql.Date;

public class PaymentHistoryVo {
	/*PB_CODE	VARCHAR2(6 BYTE)
	GROUP_CODE	VARCHAR2(5 BYTE)
	PB_DATE	DATE
	PRODUCT_CODE	VARCHAR2(5 BYTE)
	PAYER_CODE	NUMBER*/
	
	String pbCode;
	String groupCode;
	String productCode;
	Date pbDate;
	int payerCode;
	
	public PaymentHistoryVo() {
		
	}
	
	public PaymentHistoryVo(String pbCode, String groupCode, String productCode, Date pbDate, int payerCode) {
		super();
		this.pbCode = pbCode;
		this.groupCode = groupCode;
		this.productCode = productCode;
		this.pbDate = pbDate;
		this.payerCode = payerCode;
	}

	public String getPbCode() {
		return pbCode;
	}

	public void setPbCode(String pbCode) {
		this.pbCode = pbCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getPbDate() {
		return pbDate;
	}

	public void setPbDate(Date pbDate) {
		this.pbDate = pbDate;
	}

	public int getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(int payerCode) {
		this.payerCode = payerCode;
	}

	@Override
	public String toString() {
		return "PaymentHistoryVo [pbCode=" + pbCode + ", groupCode=" + groupCode + ", productCode=" + productCode
				+ ", pbDate=" + pbDate + ", payerCode=" + payerCode + "]";
	}
	
	
}
